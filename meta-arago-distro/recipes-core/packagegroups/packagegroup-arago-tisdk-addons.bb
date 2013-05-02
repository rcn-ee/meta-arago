DESCRIPTION = "Task to install additional utilities/demos for SDKs"
LICENSE = "MIT"
PR = "r7"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

# Doesn't build for hardfp - hardcodes softfp
#    arm-benchmarks

UTILS = " \
    am-sysinfo \
    dt \
    gdbserver \
    oprofile \
    nbench-byte \
    trace-cmd \
    dropbear \
    openssh-sftp-server \
    parted \
"

# Add PRU examples for am180x-evm devices
UTILS_append_am180x-evm = " ti-pru-sw-examples"

UTILS_append_omap3 = " canutils"
UTILS_append_ti33x = " canutils"

RDEPENDS_${PN} = "\
    ${UTILS} \
"
