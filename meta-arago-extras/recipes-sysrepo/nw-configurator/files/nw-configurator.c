/*
 * Copyright (C) 2023 Texas Instruments Incorporated - http://www.ti.com/
 *
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions
 *  are met:
 *
 *    Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 *    Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the
 *    distribution.
 *
 *    Neither the name of Texas Instruments Incorporated nor the names of
 *    its contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 *  "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 *  LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 *  A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 *  OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 *  SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 *  LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 *  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 *  THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 *  OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
*/

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <inttypes.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

#include <sysrepo/xpath.h>
#include <sysrepo.h>
#include <sysrepo_types.h>
#include <stdbool.h>

#define INTF_XPATH "/ietf-interfaces:interfaces/interface"
#define QBV_BRIDGE "ieee802-dot1q-bridge"
#define QBV_SCHED_BRIDGE "ieee802-dot1q-sched-bridge"

#define MAX_CMD_LEN 500

#define MAX_SUPPORTED_SOCS      1
#define MAX_PRIO                16
#define MAX_TRAFFIC_CLASS       16
#define NUM_TRAFFIC_CLASS       3

struct control_list {
	uint32_t timer_interval;
	uint8_t gate_state;
};

struct basetime {
	bool present;
	uint64_t sec;
	uint32_t nsec;
};
struct config_est {
	bool gate_en;
	uint8_t gate_states;
	uint32_t gate_list_len;
	uint32_t max_list_size;
	struct control_list *ctrl_list;
	struct basetime base_time;
};

static uint8_t exit_app;

static uint32_t prio_tc_map[MAX_PRIO] = {
        0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
};

/* Number of queues associated per class
 * 0 means, not applicable
 */
static uint8_t num_class_queues[MAX_TRAFFIC_CLASS] = {
	1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
};

static void sig_handler(int signum)
{
	exit_app = 1;
}

static void free_resources(struct config_est *config)
{
	if(config->ctrl_list)
		free(config->ctrl_list);

	return;
}

static int
alloc_resources(sr_session_ctx_t *session, sr_val_t *val,
		struct config_est *config)
{
	sr_xpath_ctx_t xpath_ctxt = {0};
	char *nodename = NULL;
	uint32_t count;

	sr_xpath_recover(&xpath_ctxt);

	nodename = sr_xpath_node_name(val->xpath);

	if (!strcmp(nodename, "supported-list-max")) {
		count = val->data.uint32_val;

		config->ctrl_list = malloc(sizeof(struct control_list)*count);

		if (!config->ctrl_list) {
			printf("ERROR: Insufficient memory\n");
			return -1;
		}
		 config->max_list_size = count;

	} else if (!strncmp(nodename, "gate-control-entry",18)){
		config->gate_list_len++;
	}

	return 0;
}

static void
parse_est_params(sr_session_ctx_t *session, sr_val_t *val,
		 struct config_est *config)
{
	sr_xpath_ctx_t xpath_ctxt = {0};
	char *nodename = NULL;
	char *index_str = NULL;
	uint64_t index;

	sr_xpath_recover(&xpath_ctxt);

	nodename = sr_xpath_node_name(val->xpath);

	if (!nodename)
		goto out;

	if (!strcmp(nodename, "gate-enabled")) {
		config->gate_en = val->data.bool_val;
	} else if (!strcmp(nodename, "admin-gate-states")) {
		config->gate_states = val->data.uint8_val;
	} else if (!strcmp(nodename, "time-interval-value")) {
		sr_xpath_recover(&xpath_ctxt);
		index_str = sr_xpath_key_value(val->xpath,
					   "gate-control-entry",
					   "index", &xpath_ctxt);

		index = strtoul(index_str, NULL, 0);
		(config->ctrl_list + index)->timer_interval =
						val->data.uint32_val;

	} else if (!strcmp(nodename, "gate-states-value")) {
		sr_xpath_recover(&xpath_ctxt);
		index_str = sr_xpath_key_value(val->xpath,
					       "gate-control-entry",
					       "index", &xpath_ctxt);

		index = strtoul(index_str, NULL, 0);
		(config->ctrl_list + index)->gate_state = val->data.uint8_val;
	} else if (!strcmp(nodename, "admin-base-time"))  {
		config->base_time.present = true;
	} else if (!strcmp(nodename, "seconds")) {
		config->base_time.sec = val->data.uint64_val;
	} else if (!strcmp(nodename, "nanoseconds")) {
		config->base_time.nsec = val->data.uint32_val;
	}

out:
	return ;
}

static int prepare_tsn_tc_cmd(char *ifname, struct config_est *config)
{
	char tc_cmd_opts[MAX_CMD_LEN];
	char tc_cmd[MAX_CMD_LEN];
	uint64_t base_time = 0;
	uint32_t offset;
	int i;

	snprintf(tc_cmd, MAX_CMD_LEN, "tc qdisc replace ");

	snprintf(tc_cmd_opts, MAX_CMD_LEN, "dev %s ", ifname);
	strncat(tc_cmd, tc_cmd_opts, MAX_CMD_LEN - 1 - strlen(tc_cmd));

	snprintf(tc_cmd_opts, MAX_CMD_LEN, "parent root handle 100 taprio ");
	strncat(tc_cmd, tc_cmd_opts, MAX_CMD_LEN - 1 - strlen(tc_cmd));

        snprintf(tc_cmd_opts, MAX_CMD_LEN, "num_tc %d map ", NUM_TRAFFIC_CLASS);
        strncat(tc_cmd, tc_cmd_opts, MAX_CMD_LEN - 1 - strlen(tc_cmd));

	for (i = 0; i < MAX_PRIO; i++) {
		snprintf(tc_cmd_opts, MAX_CMD_LEN, "%d ", prio_tc_map[i]);
		strncat(tc_cmd, tc_cmd_opts, MAX_CMD_LEN - 1 - strlen(tc_cmd));
	}

	snprintf(tc_cmd_opts, MAX_CMD_LEN, "queues ");
	strncat(tc_cmd, tc_cmd_opts, MAX_CMD_LEN - 1 - strlen(tc_cmd));

	/* First queue-class */
	i = 0;
	snprintf(tc_cmd_opts, MAX_CMD_LEN, "%d@%d ",num_class_queues[i] , 0);
	strncat(tc_cmd, tc_cmd_opts, MAX_CMD_LEN - 1 - strlen(tc_cmd));

	offset = num_class_queues[i];
	for (i = 1; i < NUM_TRAFFIC_CLASS; i++) {
		snprintf(tc_cmd_opts, MAX_CMD_LEN, "%d@%d ", num_class_queues[i], offset);
		strncat(tc_cmd, tc_cmd_opts, MAX_CMD_LEN - 1 - strlen(tc_cmd));
		offset += num_class_queues[i];
	}

	if (config->base_time.present) {
		base_time = (config->base_time.sec * 1000000000) +
			    config->base_time.nsec;

		snprintf(tc_cmd_opts, MAX_CMD_LEN, "base-time %" PRIu64 " ", base_time);
		strncat(tc_cmd, tc_cmd_opts, MAX_CMD_LEN - 1 - strlen(tc_cmd));
	}

	for (i = 0; i < config->gate_list_len; i++) {
		snprintf(tc_cmd_opts, MAX_CMD_LEN, "sched-entry S %X %d ",
			 (config->ctrl_list + i)->gate_state,
			 (config->ctrl_list + i)->timer_interval);

		strncat(tc_cmd, tc_cmd_opts, MAX_CMD_LEN - 1 - strlen(tc_cmd));
	}

	snprintf(tc_cmd_opts, MAX_CMD_LEN, "flags 2");
	strncat(tc_cmd, tc_cmd_opts, MAX_CMD_LEN - 1 - strlen(tc_cmd));

	printf("Executing command : %s\n", tc_cmd);

	system(tc_cmd);
	return 0;
}

static int
configure_est(sr_session_ctx_t *session, char *xpath, char *ifname,
	      struct config_est *config)
{
	sr_val_t *values;
	size_t count;
	int i, ret  = -1;

	ret = sr_get_items(session, xpath, 0, 0, &values, &count);

	if (ret != SR_ERR_OK) {
		printf("ERROR(%s) : sr_get_items: %s\n", sr_strerror(ret),
		       __func__);

		return ret;
	}

	/* First time scan to allocate neccessary memory */
	for (i = 0; i < count; i++) {
		alloc_resources(session, &values[i], config);
	}

	if (config->gate_list_len > config->max_list_size) {
		printf("Number of gate list entries more than "
		       "max supported entries. Check xml\n");
		printf("Not applying tc command \n");

		ret = -1;
		goto cleanup;
	}

	for (i = 0; i < count; i++) {
		parse_est_params(session, &values[i], config);
	}

	prepare_tsn_tc_cmd(ifname, config);

cleanup:
        free_resources(config);
	sr_free_values(values, count);

	return ret;
}

static int
module_change_bridge_cb(sr_session_ctx_t *session, uint32_t sub_id,
			const char  *module_name, const char *xpath, sr_event_t event,
			uint32_t request_id, void *private_data)
{
	sr_change_iter_t *iter;
	sr_change_oper_t op;
	sr_val_t *old_val;
	sr_val_t *new_val;
	sr_val_t *value;
	sr_data_t *data;
	sr_xpath_ctx_t xpath_ctx;
	char newpath[300];
	char ifname_prev[20];
	struct config_est *config = NULL;

	char *ifname;
	int ret = 1;

	ret = 0;

	ret = sr_get_changes_iter(session, xpath, &iter);
	if (ret != SR_ERR_OK) {
		printf("ERROR(%s): sr_get_changes_iter\n", sr_strerror(ret));
		goto cleanup;
	}

	config = malloc(sizeof(struct config_est));
	if (!config) {
		printf("ERROR : Insufficient memory\n");
		goto cleanup;
	}

	memset(config, 0, sizeof(struct config_est));
	memset(ifname_prev, 0, sizeof(ifname_prev));

	while (SR_ERR_OK == (ret = sr_get_change_next(session, iter,
						     &op, &old_val, &new_val))) {

		memset(config, 0, sizeof(struct config_est));

		value = new_val ? new_val : old_val;

		ifname = sr_xpath_key_value(value->xpath, "interface",
					    "name", &xpath_ctx);

		if (op == SR_OP_DELETED)
			continue;

		snprintf(newpath, 300,
			 "%s[name='%s']/%s:bridge-port/ieee802-dot1q-sched-bridge:*//*",
			 INTF_XPATH, ifname, QBV_BRIDGE);

		if (strcmp(ifname, ifname_prev)) {
			strcpy(ifname_prev, ifname);
			configure_est(session, newpath, ifname, config);
		}
	}

cleanup:
	if(config) {
		free(config);
	}

	return ret;

}

int main(int argc, char **argv)
{
	int rc;
	sr_conn_ctx_t *connection = NULL;
	sr_session_ctx_t *session = NULL;
	sr_subscription_ctx_t *if_subscription = NULL;
	sr_subscr_options_t opts;

	/* connect to sysrepo */
	rc = sr_connect(SR_CONN_DEFAULT, &connection);
	if (rc != SR_ERR_OK) {
		printf("Connecting to sysrepo failed (%s)\n", sr_strerror(rc));
		goto cleanup;
	}

	rc = sr_session_start(connection, SR_DS_RUNNING, &session);
	if (rc != SR_ERR_OK) {
		printf("Session start failed (%s)\n", sr_strerror(rc));
		goto cleanup;
	}

	opts = SR_SUBSCR_DEFAULT | SR_SUBSCR_DONE_ONLY;

	rc = sr_module_change_subscribe(session,
					"ietf-interfaces","/ietf-interfaces:interfaces/interface/ieee802-dot1q-bridge:bridge-port/ieee802-dot1q-sched-bridge:*//*",
					module_change_bridge_cb, NULL, 0, opts,
					&if_subscription);

	if (rc != SR_ERR_OK) {
		printf("Could not subscribe to module xpath :"
		       "//ietf-interfaces:interfaces//interface//ieee802-dot1q-bridge:bridge-port//bridge-name\n");
	}

	signal(SIGINT, sig_handler);

	while(!exit_app)
		sleep(1);

cleanup:
	if (session)
		sr_session_stop(session);

	if (connection)
		sr_disconnect(connection);

	return rc;
}
