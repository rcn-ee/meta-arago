DESCRIPTION = "Git repositories containing sample board port code"
HOMEPAGE = "https://gitorious.org/sitara-board-port"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit allarch

CREATE_SRCIPK = "1"
SRCIPK_INSTALL_DIR = "board-support/board-port-labs/sitara-board-port-linux"
SRCIPK_PRESERVE_GIT = "true"

PR = "r0"

BRANCH = "master"
SRC_URI = "git://gitorious.org/sitara-board-port/sitara-board-port-linux.git;protocol=git;branch=${BRANCH}"

SRCREV = "30df33e7134ab507a339b89a864256cabfbddea1"

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

