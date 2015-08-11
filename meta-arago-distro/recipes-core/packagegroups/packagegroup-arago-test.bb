DESCRIPTION = "Extended task to get System Test specific apps"
LICENSE = "MIT"
PR = "r33"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

# perf fails with 4.1 kernel
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
    v4l-utils \
    smcroute \
    rwmem \
    cpuburn-neon \
    pulseaudio-misc \
    "

ARAGO_TI_TEST = "\
    ltp-ddt \
    input-utils \
    cpuloadgen \
    "

ARAGO_TI_TEST_append_ti33x = " \
    omapconf \
    "

ARAGO_TI_TEST_append_ti43x = " \
    omapconf \
    "

ARAGO_TI_TEST_append_omap-a15 = " \
    omapconf \
    ipc-test-fw \
    "
# omap-a15 -    ${@base_contains('MACHINE_FEATURES', 'mmip', 'omapdrmtest', '', d)}

# vpdma-fw and vpe-tests both provide FW image
#    vpe-tests

ARAGO_TI_TEST_append_dra7xx = " \
    vpdma-fw \
    "

RDEPENDS_${PN} = "\
    ${ARAGO_TEST} \
    ${ARAGO_TI_TEST} \
    "
