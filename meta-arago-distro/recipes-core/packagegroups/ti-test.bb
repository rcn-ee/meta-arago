SUMMARY = "TI Testing packagegroup"
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

ARAGO_TEST = "\
    bonnie++ \
    hdparm \
    iozone3 \
    lmbench \
    rt-tests \
    evtest \
    bc \
    memtester \
    libdrm-tests \
    dma-heap-tests \
    powertop \
    stress \
    stress-ng \
    yavta \
    perf \
    v4l-utils \
    smcroute \
    rwmem \
    pulseaudio-misc \
    kernel-selftest \
    procps \
    mtd-utils-ubifs-tests \
    pcitest \
    mstpd \
    fio \
    git \
    bridge-utils \
    linuxptp \
    openntpd \
    nbench-byte \
    stream \
    cryptodev-tests \
"

ARAGO_TEST_EXTRAS = " \
    python3-numpy \
    piglit \
    ${@bb.utils.contains("DISTRO_FEATURES", "opengl", "opengl-es-cts", "", d)} \
    ${@bb.utils.contains("DISTRO_FEATURES", "vulkan", "vulkan-cts", "", d)} \
"

ARAGO_TEST:append:armv7a = " \
    cpuburn-neon \
"

ARAGO_TEST:append:armv7ve = " \
    cpuburn-neon \
"

#    timestamping
ARAGO_TI_TEST = " \
    ltp-ddt \
    input-utils \
    cpuloadgen \
    uvc-gadget \
    arm-benchmarks \
"

ARAGO_TI_TEST:append:ti33x = " \
    omapconf \
"

ARAGO_TI_TEST:append:ti43x = " \
    omapconf \
"

NOT_MAINLINE_MMIP_DEPS = "${@bb.utils.contains('MACHINE_FEATURES', 'mmip', 'omapdrmtest', '', d)}"

ARAGO_TI_TEST:append:omap-a15 = " \
    omapconf \
    ${@oe.utils.conditional('ARAGO_BRAND', 'mainline', '', " \
        ti-ipc-test \
	${NOT_MAINLINE_MMIP_DEPS} \
    ", d)} \
"

ARAGO_TI_TEST:append:k3 = " \
    k3conf \
"

ARAGO_TI_TEST:append:j721e = " \
    ufs-utils \
"

# Disable due to breakage
#    viddec-test-app 
ARAGO_TI_TEST:append:j721e = " \
    videnc-test-app \
"

ARAGO_TI_TEST:append:omapl138 = " \
    ${@oe.utils.conditional('ARAGO_BRAND', 'mainline', '', 'ti-ipc-test', d)} \
"

RDEPENDS:${PN} = "\
    ${ARAGO_TEST} \
    ${ARAGO_TI_TEST} \
"

# Package group for things that should only be present in tisdk-default-image
PACKAGES += " ${PN}-extras"
RDEPENDS:${PN}-extras = "\
    ${ARAGO_TEST_EXTRAS} \
"
