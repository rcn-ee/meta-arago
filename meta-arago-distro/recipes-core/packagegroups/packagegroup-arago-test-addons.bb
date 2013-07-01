DESCRIPTION = "Task to install additional utilities/demos for test image"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r0"

ALLOW_EMPTY = "1"

inherit packagegroup

TEST_ADDONS = " \
    bridge-utils \
    "

TEST_ADDONS_TI = " \
    "

RDEPENDS_${PN} = "\
    ${TEST_ADDONS} \
    ${TEST_ADDONS_TI} \
    "
