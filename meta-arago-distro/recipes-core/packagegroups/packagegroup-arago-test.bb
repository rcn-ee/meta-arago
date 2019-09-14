DESCRIPTION = "Extended task to get System Test specific apps"
LICENSE = "MIT"
PR = "r50"

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
    cpuset \
    procps \
    mtd-utils-ubifs-tests \
    pcitest \
    mstpd \
    fio \
    "

ARAGO_TEST_append_armv7a = " \
    cpuburn-neon \
"

ARAGO_TEST_append_armv7ve = " \
    cpuburn-neon \
"

ARAGO_TI_TEST = " \
    ltp-ddt \
    input-utils \
    cpuloadgen \
    timestamping \
    uvc-gadget \
    "

ARAGO_TI_TEST_append_ti33x = " \
    omapconf \
    "

ARAGO_TI_TEST_append_ti43x = " \
    omapconf \
    "

ARAGO_TI_TEST_append_omap-a15 = " \
    omapconf \
    ti-ipc-test \
    "

ARAGO_TI_TEST_append_am65xx = " \
    ti-ipc-test \
    "

ARAGO_TI_TEST_append_j7-evm = " \
    viddec-test-app \
    videnc-test-app \
    ufs-tool \
    "

ARAGO_TI_TEST_append_keystone = " \
    ti-ipc-test \
    "

ARAGO_TI_TEST_append_omapl138 = " \
    ti-ipc-test \
    "

RDEPENDS_${PN} = "\
    ${ARAGO_TEST} \
    ${ARAGO_TI_TEST} \
    "
