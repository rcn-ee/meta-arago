PR_append = ".arago0"

CM_NAME = "OpenCL"
CM_VERSION = "${PV}"
CM_ROOT_DIR = "opencl_rtos_${RELEASE_TARGET}_${@'${PV}'.replace('.', '_')}"
CM_DESCRIPTION = "OpenCL is a framework for writing programs that execute across heterogeneous systems"

deltask do_create_srcipk
addtask create_srcipk after do_install before do_package

CREATE_SRCIPK = "1"
SRCIPK_SRC_DIR = "${DESTDIR}"
SRCIPK_INSTALL_DIR = "${CM_ROOT_DIR}"
