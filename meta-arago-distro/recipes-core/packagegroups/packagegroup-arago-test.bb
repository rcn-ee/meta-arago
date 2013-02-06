DESCRIPTION = "Extended task to get System Test specific apps"
LICENSE = "MIT"
PR = "r2"

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
    "

ARAGO_TI_TEST = "\
    ltp-ddt \
    "

RDEPENDS_${PN} = "\
    ${ARAGO_TEST} \
    ${ARAGO_TI_TEST} \
    "
