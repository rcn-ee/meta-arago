DESCRIPTION = "Git repositories containing sample board port code"
HOMEPAGE = "https://gitorious.org/sitara-board-port"
LICENSE = "GPLv2"
DEPENDS += "git-native"

LIC_FILES_CHKSUM = "file://../LICENSE;md5=d9fb2a547cd8e6bb75c0ecf427a139a9"

PACKAGE_ARCH = "all"

CREATE_SRCIPK = "1"
SRCIPK_INSTALL_DIR = "board-support/board-port-labs"

PR = "r1"

BRANCH = "board-port-05.05.00.00"

SRC_URI = "\
    file://LICENSE \
    git://gitorious.org/sitara-board-port/sitara-board-port-linux.git;protocol=git;branch=${BRANCH};destsuffix=board-support/sitara-board-port-linux;name=board-support-linux \
    git://gitorious.org/sitara-board-port/sitara-board-port-uboot.git;protocol=git;branch=${BRANCH};destsuffix=board-support/sitara-board-port-uboot;name=board-support-u-boot \
"

SRCREV_board-support-linux = "eaf6d6b4447b132592896fb87d914d130892cd2e"
SRCREV_board-support-u-boot = "c817fbabece6218f128dc1ce4410563d503cecae"

S = "${WORKDIR}/board-support"
