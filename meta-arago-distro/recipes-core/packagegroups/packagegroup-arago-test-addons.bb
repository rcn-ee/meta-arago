DESCRIPTION = "Task to install additional utilities/demos for test image"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r11"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

TEST_ADDONS = " \
    bridge-utils \
    linuxptp \
    openntpd \
    strongswan \
    "

TEST_ADDONS_TI = " \
    cmem-test \
    "

TEST_ADDONS_TI_append_omap-a15 = " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'mmip', 'omapdrmtest', '', d)} \
    "

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
    ipsecmgr \
    "

# The following are not yet ready for k2g-evm
#    nwal-lld-test
#    hplib-test
#    nwal-lld
#    ipc-transport-qmss-test
#    netapi-test

TEST_ADDONS_TI_append_k2hk-evm = " \
    srio-lld-test \
    ipc-transport-srio-test \
    ipc-transport-qmss-test \
    hyplnk-lld-test \
    mmap-lld-test \
    aif2-lld-test \
    nwal-lld-test \
    hplib-test \
    nwal-lld \
    netapi-test \
    "

TEST_ADDONS_TI_append_k2l-evm = " \
    dfe-lld-test \
    iqn2-lld-test \
    nwal-lld-test \
    hplib-test \
    nwal-lld \
    ipc-transport-qmss-test \
    netapi-test \
    "

TEST_ADDONS_TI_append_k2e-evm = " \
    mmap-lld-test \
    hyplnk-lld-test \
    nwal-lld-test \
    hplib-test \
    nwal-lld \
    ipc-transport-qmss-test \
    netapi-test \
    "

RDEPENDS_${PN} = "\
    ${TEST_ADDONS} \
    ${TEST_ADDONS_TI} \
    "
