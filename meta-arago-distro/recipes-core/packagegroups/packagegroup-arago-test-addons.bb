DESCRIPTION = "Task to install additional utilities/demos for test image"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r14"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

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
    ${TEST_ADDONS} \
    ${TEST_ADDONS_TI} \
    "
