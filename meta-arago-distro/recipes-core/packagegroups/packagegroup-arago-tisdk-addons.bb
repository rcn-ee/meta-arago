DESCRIPTION = "Task to install additional utilities/demos for SDKs"
LICENSE = "MIT"
PR = "r59"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES =+ "${PN}-extra"

#    dt

UTILS = " \
    am-sysinfo \
    gdbserver \
    oprofile \
    nbench-byte \
    trace-cmd \
    arm-benchmarks \
    dropbear \
    openssh-sftp-server \
    ptpd \
    libdrm-kms \
    kms++ \
    kms++-python \
    ${@bb.utils.contains('TUNE_FEATURES', 'armv7a', 'valgrind', '', d)} \
    stream \
    strongswan \
    kexec \
    kdump \
"

UTILS_UBOOT_FW = "u-boot-fw-utils"
UTILS_UBOOT_FW_keystone = ""

UTILS_append_ti33x = " mmc-utils \
                       canutils \
                       switch-config \
                       pru-icss \
"

UTILS_append_ti43x = " mmc-utils \
                       canutils \
                       switch-config \
                       libdrm-omap \
                       pru-icss \
"

UTILS_append_omap-a15 = " mmc-utils \
                          parted \
                          switch-config \
                          libdrm-omap \
                          stream-openmp \
                          pru-icss \
                          ti-ipc-rtos-fw \
                          uio-test-pruss \
                          uio-module-drv-test \
"

UTILS_append_dra7xx = " canutils \
                        dsptop \
                        gdbc6x \
                        glsdk-example-apps \
"

UTILS_append_keystone = " \
    uio-module-drv-test \
    ti-ipc-rtos-fw \
"

UTILS_append_k2hk = " \
    gdbc6x \
    dsptop \
"

UTILS_append_k2l-evm = " \
    gdbc6x \
    dsptop \
"

UTILS_append_k2e = " \
    gdbc6x \
    dsptop \
"

UTILS_append_k2g = " \
    canutils \
    pru-icss \
"

EXTRA_LIBS = ""
EXTRA_LIBS_append_omap-a15 = " \
    cmem \
    uio-module-drv \
"

EXTRA_LIBS_append_keystone = " \
    cmem \
    uio-module-drv \
"

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

EXTRA_PACKAGES_omapl138 = " \
    protobuf \
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
