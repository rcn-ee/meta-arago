DESCRIPTION = "Task to install additional utilities/demos for SDKs"
LICENSE = "MIT"
PR = "r29"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

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
    ${@base_contains('TUNE_FEATURES', 'armv7a', 'valgrind', '', d)} \
    stream \
"

UTILS_UBOOT_FW = "u-boot-fw-utils"
UTILS_UBOOT_FW_keystone = ""

UTILS_append_ti33x = " mmc-utils"
UTILS_append_ti43x = " mmc-utils"
UTILS_append_omap-a15 = " mmc-utils"

# Add PRU examples for am180x-evm devices
UTILS_append_am180x-evm = " ti-pru-sw-examples"

UTILS_append_omap3 = " canutils"
UTILS_append_ti33x = " canutils"
UTILS_append_ti43x = " canutils"
UTILS_append_dra7xx = " canutils dsptop gdbc6x"
UTILS_append_omap-a15 = " parted"

UTILS_append_ti33x = " switch-config"
UTILS_append_ti43x = " switch-config libdrm-omap"
UTILS_append_omap-a15 = " switch-config libdrm-omap stream-openmp"

EXTRA_LIBS = ""
EXTRA_LIBS_append_omap-a15 = " cmem"

DEVTOOLS = " \
    packagegroup-core-buildessential \
    git \
"

RDEPENDS_${PN} = "\
    ${UTILS} \
    ${UTILS_UBOOT_FW} \
    ${DEVTOOLS} \
    ${EXTRA_LIBS} \
"
