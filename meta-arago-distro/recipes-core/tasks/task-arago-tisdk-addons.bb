DESCRIPTION = "Task to install additional utilities/demos for SDKs"
PR = "r0"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit task
PACKAGE_ARCH = "${MACHINE_ARCH}"

UTILS = " \
    matrix-gui-settings-demos \
    matrix-gui-armbenchmarks-demos \
    task-arago-test \
    gdbserver \
    matrix-gui-oprofile-demos \
    "

# Add PRU examples for am180x-evm devices
# UTILS_append_am180x-evm = " ti-pru-sw-examples"

RDEPENDS_${PN} = "\
    ${UTILS} \
    "
