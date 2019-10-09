DESCRIPTION = "Task to install additional utilities/demos for SDKs"
LICENSE = "MIT"
PR = "r76"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES =+ "${PN}-extra"

#    dt

UTILS = " \
    am-sysinfo \
    gdbserver \
    oprofile \
    nbench-byte \
    arm-benchmarks \
    dropbear \
    openssh-sftp-server \
    netkit-ftp \
    ptpd \
    libdrm-kms \
    kms++ \
    kms++-python \
    ${@bb.utils.contains('TUNE_FEATURES', 'armv7a', 'valgrind', '', d)} \
    stream \
    strongswan \
    kexec \
    kdump \
    open62541-examples \
    open62541-tests \
"

UTILS_UBOOT_FW = "u-boot-fw-utils"
UTILS_UBOOT_FW_keystone = ""
UTILS_UBOOT_FW_k3 = ""

UTILS_DSP = " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'dsp', 'gdbc6x dsptop', '', d)} \
"

UTILS_append_ti33x = " mmc-utils \
                       can-utils \
                       switch-config \
                       pru-icss \
                       pru-swuart-fw \
                       uio-module-drv-test \
                       uio-test-pruss \
"

UTILS_append_ti43x = " mmc-utils \
                       can-utils \
                       switch-config \
                       libdrm-omap \
                       pru-icss \
                       uio-module-drv-test \
                       uio-test-pruss \
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

UTILS_append_k3 = " mmc-utils \
                    can-utils \
                    parted \
                    switch-config \
                    irqbalance \
                    jailhouse \
"

UTILS_append_am65xx = " ipc-lld-fw ti-ipc-rtos-fw pru-icss pru-pwm-fw"
UTILS_append_j7-evm = " ipc-lld-fw pru-icss ti-display-sharing-fw cpsw9g-eth-fw"

UTILS_append_omapl138 = " ti-ipc-rtos-fw"

UTILS_append_dra7xx = " can-utils \
                        ${UTILS_DSP} \
                        ${@bb.utils.contains('MACHINE_FEATURES','gpu','glsdk-example-apps','',d)} \
"

UTILS_append_keystone = " \
    uio-module-drv-test \
    ti-ipc-rtos-fw \
"

UTILS_append_k2hk = " \
    ${UTILS_DSP} \
"

UTILS_append_k2l = " \
    ${UTILS_DSP} \
"

UTILS_append_k2e = " \
    ${UTILS_DSP} \
"

UTILS_append_k2g = " \
    can-utils \
    pru-icss \
    uio-test-pruss \
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

EXTRA_LIBS_append_ti43x = " \
    cmem \
    uio-module-drv \
"

EXTRA_LIBS_append_ti33x = " \
    uio-module-drv \
"

DEVTOOLS = " \
    linux-libc-headers-dev \
    packagegroup-core-buildessential \
    packagegroup-core-tools-debug \
    git \
"

EXTRA_PACKAGES = " \
    nodejs \
    nodejs-npm \
    protobuf \
    ccief-basic \
"

EXTRA_PACKAGES_omapl138 = " \
    protobuf \
"

ARMNN_PACKAGES = "armnn"

EXTRA_PACKAGES_append_ti33x = " voxelsdk \
                                arm-compute-library \
                                ${ARMNN_PACKAGES} \
                                tensorflow-lite-examples \
                                pdm-anomaly-detection \
"

EXTRA_PACKAGES_append_ti43x = " voxelsdk \
                                arm-compute-library \
                                ${ARMNN_PACKAGES} \
                                tensorflow-lite-examples \
                                pdm-anomaly-detection \
"

EXTRA_PACKAGES_append_omap-a15 = " voxelsdk \
                                   big-data-ipc-demo-linux \
                                   big-data-ipc-demo-linux-firmware \
                                   arm-compute-library \
                                   ${ARMNN_PACKAGES} \
                                   tensorflow-lite-examples \
                                   pdm-anomaly-detection \
"

EXTRA_PACKAGES_append_am65xx = " arm-compute-library \
                             ${ARMNN_PACKAGES} \
                             tensorflow-lite-examples \
                             pdm-anomaly-detection \
"

EXTRA_PACKAGES_append_omap-a15 = " ti-ipc-examples-linux"
EXTRA_PACKAGES_append_keystone = " ti-ipc-examples-linux"
EXTRA_PACKAGES_append_omapl138 = " ti-ipc-examples-linux"
EXTRA_PACKAGES_append_am65xx = " ti-ipc-examples-linux"

EXTRA_PACKAGES_append_am335x-evm = " pruss-lld-apps acontis-atemsys"
EXTRA_PACKAGES_append_am437x-evm = " pruss-lld-apps"
EXTRA_PACKAGES_append_am57xx-evm = " pruss-lld-apps acontis-atemsys"
EXTRA_PACKAGES_append_k2g-evm  = " pruss-lld-apps"

RDEPENDS_${PN} = "\
    ${UTILS} \
    ${UTILS_UBOOT_FW} \
    ${DEVTOOLS} \
    ${EXTRA_LIBS} \
"

RDEPENDS_${PN}-extra = "\
    ${EXTRA_PACKAGES} \
"
