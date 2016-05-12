DESCRIPTION = "Extended task to get System Test specific apps"
LICENSE = "MIT"
PR = "r42"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

ARAGO_TEST = "\
    bonnie++ \
    hdparm \
    iozone3 \
    iperf \
    lmbench \
    rt-tests \
    evtest \
    bc \
    memtester \
    libdrm-tests \
    powertop \
    stress \
    yavta \
    rng-tools \
    perf \
    v4l-utils \
    smcroute \
    rwmem \
    cpuburn-neon \
    pulseaudio-misc \
    kselftests \
    cpuset \
    procps \
    mtd-utils-ubifs-tests \
    "

ARAGO_TI_TEST = "\
    ltp-ddt \
    input-utils \
    cpuloadgen \
    timestamping \
    "

ARAGO_TI_TEST_append_ti33x = " \
    omapconf \
    "

ARAGO_TI_TEST_append_ti43x = " \
    omapconf \
    "

#    ${@bb.utils.contains('MACHINE_FEATURES', 'mmip', 'omapdrmtest', '', d)}
ARAGO_TI_TEST_append_omap-a15 = " \
    omapconf \
    ti-ipc-test \
    "

ARAGO_TI_TEST_append_dra7xx = " \
    vpe-tests \
    "

ARAGO_TI_TEST_append_keystone = " \
    ti-ipc-test \
    "

RDEPENDS_${PN} = "\
    ${ARAGO_TEST} \
    ${ARAGO_TI_TEST} \
    "
