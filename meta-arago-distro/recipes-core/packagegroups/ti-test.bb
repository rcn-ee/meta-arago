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

ARAGO_TI_TEST_append_omap-a15 = " \
    omapconf \
    ${@oe.utils.conditional('ARAGO_BRAND', 'mainline', '', ' \
        ti-ipc-test \
        ${@bb.utils.contains('MACHINE_FEATURES', 'mmip', 'omapdrmtest', '', d)} \
        cmem-test \
    ', d)} \
"

ARAGO_TI_TEST_append_k3 = " \
    k3conf \
"

ARAGO_TI_TEST_append_j7 = " \
    ufs-utils \
"

ARAGO_TI_TEST_append_omapl138 = " \
    ${@oe.utils.conditional('ARAGO_BRAND', 'mainline', '', 'ti-ipc-test', d)} \
"

# Disable ipsecmgr due to libnl and xfrm conflict
#    ipsecmgr
ARAGO_TI_TEST_append_keystone = " \
    ${@oe.utils.conditional('ARAGO_BRAND', 'mainline', '', ' \
        ti-ipc-test \
        mpm-transport-test \
        multiprocmgr-test \
        qmss-lld-test \
        cppi-lld-test \
        edma3-lld-test \
        rm-lld \
        rm-lld-test \
        traceframework-test \
        udma-test \
        cmem-test \
    ', d)} \
"

# The following are not yet ready for k2g-evm
#    nwal-lld-test
#    hplib-test
#    nwal-lld
#    ipc-transport-qmss-test
#    netapi-test

# Disable netapi due to libnl and xfrm conflict
#    netapi-test
# Disable hplib-test,nwal-lld due to hplib-mod breakage against K4.14
#    hplib-test
#    nwal-lld-test
#    nwal-lld
ARAGO_TI_TEST_append_k2hk = " \
    ${@oe.utils.conditional('ARAGO_BRAND', 'mainline', '', ' \
        srio-lld-test \
        ipc-transport-srio-test \
        ipc-transport-qmss-test \
        hyplnk-lld-test \
        mmap-lld-test \
        aif2-lld-test \
        pa-lld-test \
        sa-lld \
        sa-lld-test \
    ', d)} \
"

# Disable netapi due to libnl and xfrm conflict
#    netapi-test
# Disable hplib-test,nwal-lld due to hplib-mod breakage against K4.14
#    hplib-test
#    nwal-lld-test
#    nwal-lld
ARAGO_TI_TEST_append_k2l = " \
    ${@oe.utils.conditional('ARAGO_BRAND', 'mainline', '', ' \
        dfe-lld-test \
        iqn2-lld-test \
        ipc-transport-qmss-test \
        pa-lld-test \
        sa-lld \
        sa-lld-test \
    ', d)} \
"

# Disable netapi due to libnl and xfrm conflict
#    netapi-test
# Disable hplib-test,nwal-lld due to hplib-mod breakage against K4.14
#    hplib-test
#    nwal-lld-test
#    nwal-lld
ARAGO_TI_TEST_append_k2e = " \
    ${@oe.utils.conditional('ARAGO_BRAND', 'mainline', '', ' \
        mmap-lld-test \
        hyplnk-lld-test \
        ipc-transport-qmss-test \
        pa-lld-test \
        sa-lld \
        sa-lld-test \
    ', d)} \
"

RDEPENDS_${PN} = "\
    ${ARAGO_TEST} \
    ${ARAGO_TI_TEST} \
"
