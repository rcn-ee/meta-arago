DESCRIPTION = "Task to install additional utilities/demos for SDKs"
LICENSE = "MIT"
PR = "r43"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES =+ "${PN}-extra"

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
                          ti-ipc-rtos-fw \
"

# Add PRU examples for am180x-evm devices
UTILS_append_am180x-evm = " ti-pru-sw-examples"

UTILS_append_omap3 = " canutils"

UTILS_append_dra7xx = " canutils \
                        dsptop \
                        gdbc6x \
                        glsdk-example-apps \
                        opencl-examples \
"

UTILS_append_keystone = " \
    ti-ipc-rtos-fw \
"

UTILS_append_k2hk-evm = " \
    opencl-examples \
    gdbc6x \
    dsptop \
"

UTILS_append_k2l-evm = " \
    opencl-examples \
    gdbc6x \
    dsptop \
"

UTILS_append_k2e-evm = " \
    opencl-examples \
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

EXTRA_PACKAGES = " \
    nodejs \
    nodejs-npm \
    protobuf \
"
EXTRA_PACKAGES_append_dra7xx = " \
    opencl-staticdev \
    opencl-examples-dev \
    openmpacc-examples-dev \
"
EXTRA_PACKAGES_append_k2hk-evm = " \
    opencl-staticdev \
    opencl-examples-dev \
    openmpacc-examples-dev \
    linalg-examples \
"
EXTRA_PACKAGES_append_k2l-evm = " \
    opencl-staticdev \
    opencl-examples-dev \
    openmpacc-examples-dev \
"
EXTRA_PACKAGES_append_k2e-evm = " \
    opencl-staticdev \
    opencl-examples-dev \
    openmpacc-examples-dev \
"

RDEPENDS_${PN} = "\
    ${UTILS} \
    ${UTILS_UBOOT_FW} \
    ${DEVTOOLS} \
    ${EXTRA_LIBS} \
"

RDEPENDS_${PN}-extra = "\
    ${EXTRA_PACKAGES} \
"
