DESCRIPTION = "Task to install additional utilities/demos for SDKs"
LICENSE = "MIT"
PR = "r16"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

UTILS = " \
    am-sysinfo \
    dt \
    gdbserver \
    oprofile \
    nbench-byte \
    trace-cmd \
    arm-benchmarks \
    dropbear \
    openssh-sftp-server \
    ptpd \
    libdrm-kms \
"

UTILS_UBOOT_FW = "u-boot-fw-utils"
UTILS_UBOOT_FW_ti43x = ""
UTILS_UBOOT_FW_keystone = ""

UTILS_append_ti33x = " mmc-utils"
UTILS_append_ti43x = " mmc-utils"
UTILS_append_omap-a15 = " mmc-utils"

# Add PRU examples for am180x-evm devices
UTILS_append_am180x-evm = " ti-pru-sw-examples"

UTILS_append_omap3 = " canutils"
UTILS_append_ti33x = " canutils"
UTILS_append_ti43x = " canutils"
UTILS_append_omap-a15 = " parted"

RDEPENDS_${PN} = "\
    ${UTILS} \
    ${UTILS_UBOOT_FW} \
"
