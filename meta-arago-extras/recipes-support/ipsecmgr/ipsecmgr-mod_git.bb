SUMMARY = "IPSec Manager kernel module"
DESCRIPTION = "Provides Module to offload IPSec security policy & associated security association to NETCP for crypto operations"

LIC_FILES_CHKSUM = "file://../../ipsecmgr_snoop.h;beginline=1;endline=33;md5=f7eadca4fb5599f508dc11fa1e752919"

include ipsecmgr.inc

MACHINE_KERNEL_PR_append = "a"
PR = "${MACHINE_KERNEL_PR}"

EXTRA_OEMAKE += "KDIR="${STAGING_KERNEL_DIR}""

inherit module

S = "${WORKDIR}/git/src/module"

do_install() {
# Install kernel module
	oe_runmake INSTALL_MOD_PATH="${D}" install
}
