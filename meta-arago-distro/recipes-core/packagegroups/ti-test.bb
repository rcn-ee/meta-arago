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
    git \
"

ARAGO_TEST_append_armv7a = " \
    cpuburn-neon \
"

ARAGO_TEST_append_armv7ve = " \
    cpuburn-neon \
"

#    timestamping
ARAGO_TI_TEST = " \
    ltp-ddt \
    input-utils \
    cpuloadgen \
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

TEST_ADDONS = " \
    bridge-utils \
    linuxptp \
    openntpd \
"

TEST_ADDONS_TI = ""

TEST_ADDONS_TI_append_ti43x = " \
    cmem-test \
"

TEST_ADDONS_TI_append_omap-a15 = " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'mmip', 'omapdrmtest', '', d)} \
    cmem-test \
"

# Disable ipsecmgr due to libnl and xfrm conflict
#    ipsecmgr
TEST_ADDONS_TI_append_keystone = " \
    mpm-transport-test \
    multiprocmgr-test \
    qmss-lld-test \
    pa-lld-test \
    cppi-lld-test \
    edma3-lld-test \
    rm-lld \
    rm-lld-test \
    sa-lld \
    sa-lld-test \
    traceframework-test \
    udma-test \
    cmem-test \
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
TEST_ADDONS_TI_append_k2hk = " \
    srio-lld-test \
    ipc-transport-srio-test \
    ipc-transport-qmss-test \
    hyplnk-lld-test \
    mmap-lld-test \
    aif2-lld-test \
"

# Disable netapi due to libnl and xfrm conflict
#    netapi-test
# Disable hplib-test,nwal-lld due to hplib-mod breakage against K4.14
#    hplib-test
#    nwal-lld-test
#    nwal-lld
TEST_ADDONS_TI_append_k2l = " \
    dfe-lld-test \
    iqn2-lld-test \
    ipc-transport-qmss-test \
"

# Disable netapi due to libnl and xfrm conflict
#    netapi-test
# Disable hplib-test,nwal-lld due to hplib-mod breakage against K4.14
#    hplib-test
#    nwal-lld-test
#    nwal-lld
TEST_ADDONS_TI_append_k2e = " \
    mmap-lld-test \
    hyplnk-lld-test \
    ipc-transport-qmss-test \
"

RDEPENDS_${PN} = "\
    ${ARAGO_TEST} \
    ${ARAGO_TI_TEST} \
    ${TEST_ADDONS} \
    ${TEST_ADDONS_TI} \
"
