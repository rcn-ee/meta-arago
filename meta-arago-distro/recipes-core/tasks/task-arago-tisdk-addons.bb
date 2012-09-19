DESCRIPTION = "Task to install additional utilities/demos for SDKs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r1"

inherit task
PACKAGE_ARCH = "${MACHINE_ARCH}"

UTILS = " \
    am-sysinfo \
    dt \
    task-arago-test \
    gdbserver \
    oprofile \
    nbench-byte \
    trace-cmd \
    arm-benchmarks \
    dropbear \
    openssh-sftp-server \
"

# Add PRU examples for am180x-evm devices
UTILS_append_am180x-evm = " ti-pru-sw-examples"

RDEPENDS_${PN} = "\
    ${UTILS} \
"
