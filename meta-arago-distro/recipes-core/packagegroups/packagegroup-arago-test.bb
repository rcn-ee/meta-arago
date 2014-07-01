DESCRIPTION = "Extended task to get System Test specific apps"
LICENSE = "MIT"
PR = "r18"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

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
    "

ARAGO_TI_TEST_am57xx-evm = ""
ARAGO_TI_TEST = "\
    ltp-ddt \
    input-utils \
    linaro-pm-qa-utils \
    cpuloadgen \
    "

ARAGO_TI_TEST_append_omap-a15 = " \
    omapconf \
    ipc-test-fw \
    ${@base_contains('MACHINE_FEATURES', 'mmip', 'omapdrmtest', '', d)} \
    bvtest \
    "

ARAGO_TI_TEST_append_dra7xx = " \
    vpe-vpdma \
    "

RDEPENDS_${PN} = "\
    ${ARAGO_TEST} \
    ${ARAGO_TI_TEST} \
    "
