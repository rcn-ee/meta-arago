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
    rng-tools \
    perf \
    v4l-utils \
    smcroute \
    rwmem \
    pulseaudio-misc \
    kselftests \
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
"

ARAGO_TEST_append_armv7a = " \
    cpuburn-neon \
"

ARAGO_TEST_append_armv7ve = " \
    cpuburn-neon \
"

#    timestamping
#    ltp-ddt
ARAGO_TI_TEST = " \
    input-utils \
    cpuloadgen \
    uvc-gadget \
    arm-benchmarks \
"

ARAGO_TI_TEST_append_ti33x = " \
    omapconf \
"

ARAGO_TI_TEST_append_ti43x = " \
    omapconf \
    ${@oe.utils.conditional('ARAGO_BRAND', 'mainline', '', 'cmem-test', d)} \
"

NOT_MAINLINE_MMIP_DEPS = "${@bb.utils.contains('MACHINE_FEATURES', 'mmip', 'omapdrmtest', '', d)}"

ARAGO_TI_TEST_append_omap-a15 = " \
    omapconf \
    ${@oe.utils.conditional('ARAGO_BRAND', 'mainline', '', " \
        ti-ipc-test \
        cmem-test \
	${NOT_MAINLINE_MMIP_DEPS} \
    ", d)} \
"

ARAGO_TI_TEST_append_k3 = " \
    k3conf \
"

ARAGO_TI_TEST_append_j7 = " \
    ufs-utils \
    viddec-test-app \
    videnc-test-app \
"

ARAGO_TI_TEST_append_omapl138 = " \
    ${@oe.utils.conditional('ARAGO_BRAND', 'mainline', '', 'ti-ipc-test', d)} \
"

RDEPENDS_${PN} = "\
    ${ARAGO_TEST} \
    ${ARAGO_TI_TEST} \
"
