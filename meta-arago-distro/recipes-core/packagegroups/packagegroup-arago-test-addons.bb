DESCRIPTION = "Task to install additional utilities/demos for test image"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r4"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

TEST_ADDONS = " \
    bridge-utils \
    linuxptp \
    openntpd \
    strongswan \
    gdb \
    "

TEST_ADDONS_TI = " \
    cmem-test \
    "

TEST_ADDONS_TI_append_keystone = " \
    mpm-transport-test \
    multiprocmgr-test \
    "

#    qmss-lld-test \
#    pa-lld-test \
#    cppi-lld-test \
#    hyplnk-lld-test \
#    edma3-lld-test \
#    mmap-lld-test \
#    rm-lld \
#    rm-lld-test \
#    sa-lld \
#    sa-lld-test \
#    traceframework-test \
#    hplib-test \
#    hyplnk-lld-test \
#    nwal-lld \
#    nwal-lld-test \
#    udma-test \
#    ipc-transport-qmss-test \
#    ipsecmgr \
#    netapi-test \
#    "

#TEST_ADDONS_TI_append_k2hk-evm = " \
#    srio-lld-test \
#    ipc-transport-srio-test \
#    "

#TEST_ADDONS_TI_append_k2l-evm = " \
#    dfe-lld-test \
#    iqn2-lld-test \
#    "

RDEPENDS_${PN} = "\
    ${TEST_ADDONS} \
    ${TEST_ADDONS_TI} \
    "
