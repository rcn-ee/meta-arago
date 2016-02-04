DESCRIPTION = "Task to install additional utilities/demos for SDKs"
LICENSE = "MIT"
PR = "r37"

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

UTILS_append_ti33x = " mmc-utils \
                       canutils \
                       switch-config \
                       pru-icss \
                       strongswan \
"

UTILS_append_ti43x = " mmc-utils \
                       canutils \
                       switch-config \
                       libdrm-omap \
                       pru-icss \
                       strongswan \
"

UTILS_append_omap-a15 = " mmc-utils \
                          parted \
                          switch-config \
                          libdrm-omap \
                          stream-openmp \
                          pru-icss \
                          strongswan \
"

# Add PRU examples for am180x-evm devices
UTILS_append_am180x-evm = " ti-pru-sw-examples"

UTILS_append_omap3 = " canutils"

UTILS_append_dra7xx = " canutils \
                        dsptop \
                        gdbc6x \
                        glsdk-example-apps \
                        opencl-staticdev \
                        opencl-examples-dev \
"

UTILS_append_k2hk-evm = " \
    opencl-staticdev \
    opencl-examples-dev \
    gdbc6x \
    dsptop \
"

UTILS_append_k2l-evm = " \
    opencl-staticdev \
    opencl-examples-dev \
    gdbc6x \
    dsptop \
"

UTILS_append_k2e-evm = " \
    opencl-staticdev \
    opencl-examples-dev \
    gdbc6x \
    dsptop \
"

UTILS_append_k2g-evm = " canutils"

EXTRA_LIBS = ""
EXTRA_LIBS_append_omap-a15 = " cmem"

DEVTOOLS = " \
    packagegroup-core-buildessential \
    packagegroup-core-tools-debug \
    git \
"

DEVTOOLS_append_ti33x = " \
    nodejs \
"

DEVTOOLS_append_ti43x = " \
    nodejs \
"

DEVTOOLS_append_omap-a15 = " \
    nodejs \
"

RDEPENDS_${PN} = "\
    ${UTILS} \
    ${UTILS_UBOOT_FW} \
    ${DEVTOOLS} \
    ${EXTRA_LIBS} \
"
