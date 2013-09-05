DESCRIPTION = "Git repositories containing sample board port code"
HOMEPAGE = "https://gitorious.org/sitara-board-port"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

inherit allarch

CREATE_SRCIPK = "1"
SRCIPK_INSTALL_DIR = "board-support/board-port-labs/sitara-board-port-u-boot"
SRCIPK_PRESERVE_GIT = "true"

PR = "r0"

BRANCH = "master"
SRC_URI = "git://gitorious.org/sitara-board-port/sitara-board-port-uboot.git;protocol=git;branch=${BRANCH}"

SRCREV = "43a81af5ccddc67f9ed5f11664e5478f59574102"

S = "${WORKDIR}/git"

adjust_git_prepend() {

    # Checkout a specific branch instead of a commit that is used by default
    git checkout ${BRANCH}
}

do_configure() {
    :
}

do_compile() {
    :
}

