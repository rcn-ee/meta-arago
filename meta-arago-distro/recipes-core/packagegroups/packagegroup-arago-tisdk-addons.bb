DESCRIPTION = "Task to install additional utilities/demos for SDKs"
LICENSE = "MIT"
PR = "r80"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES =+ "${PN}-extra"

#    dt

UTILS = " \
    am-sysinfo \
    gdbserver \
    oprofile \
    netkit-ftp \
    ptpd \
    libdrm-kms \
    strongswan \
    kexec \
    kdump \
    open62541-examples \
    open62541-tests \
"

UTILS_UBOOT_FW = "libubootenv-bin"

UTILS_DSP = " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'dsp', 'gdbc6x dsptop', '', d)} \
"

#                       pru-swuart-fw 
UTILS:append:ti33x = " mmc-utils \
                       switch-config \
                       pru-icss \
                       uio-module-drv-test \
                       uio-test-pruss \
"

UTILS:append:ti43x = " mmc-utils \
                       switch-config \
                       libdrm-omap \
                       pru-icss \
                       uio-module-drv-test \
                       uio-test-pruss \
"

UTILS:append:omap-a15 = " mmc-utils \
                          switch-config \
                          libdrm-omap \
                          stream-openmp \
                          pru-icss \
                          ti-ipc-rtos-fw \
                          uio-test-pruss \
                          uio-module-drv-test \
"

UTILS:append:k3 = " mmc-utils \
                    switch-config \
                    irqbalance \
                    ti-rpmsg-char \
                    ti-rpmsg-char-examples \
                    statcol \
"

UTILS:append:am64xx = " ti-rtos-firmware pru-icss"
#UTILS:append:am65xx = " ti-rtos-firmware pru-icss pru-pwm-fw"
UTILS:append:am65xx = " ti-rtos-firmware pru-icss"
UTILS:append:j7 = " ti-rtos-firmware"
UTILS:append:j7-evm = " pru-icss"
UTILS:append:j7-hs-evm = " pru-icss"

UTILS:append:omapl138 = " ti-ipc-rtos-fw"

UTILS:append:dra7xx = " \
                        ${UTILS_DSP} \
                        ${@bb.utils.contains('MACHINE_FEATURES','gpu','glsdk-example-apps','',d)} \
"

EXTRA_LIBS = ""
EXTRA_LIBS:append:omap-a15 = " \
    cmem \
    uio-module-drv \
"

EXTRA_LIBS:append:ti43x = " \
    cmem \
    uio-module-drv \
"

EXTRA_LIBS:append:ti33x = " \
    uio-module-drv \
"

EXTRA_PACKAGES = " \
    nodejs \
    nodejs-npm \
    protobuf \
    ccief-basic \
"

EXTRA_PACKAGES:omapl138 = " \
    protobuf \
"

EXTRA_PACKAGES:append:omap-a15 = " ti-ipc-examples-linux"
EXTRA_PACKAGES:append:omapl138 = " ti-ipc-examples-linux"

EXTRA_PACKAGES:append:omap-a15 = " \
    ${@bb.utils.contains('MACHINE_FEATURES','dsp','big-data-ipc-demo-linux big-data-ipc-demo-linux-firmware','',d)} \
"

# acontis-atemsys
#EXTRA_PACKAGES:append:am335x-evm = " pruss-lld-apps"
#EXTRA_PACKAGES:append:am437x-evm = " pruss-lld-apps"
# acontis-atemsys
#EXTRA_PACKAGES:append:am57xx-evm = " pruss-lld-apps"

RDEPENDS:${PN} = "\
    ${UTILS} \
    ${UTILS_UBOOT_FW} \
    ${EXTRA_LIBS} \
"

RDEPENDS:${PN}-extra = "\
    ${EXTRA_PACKAGES} \
"
