DESCRIPTION = "Git repositories containing sample board port code"
HOMEPAGE = "https://gitorious.org/sitara-board-port"
LICENSE = "GPLv2"
DEPENDS += "git-native"

SRC_URI = "file://LICENSE"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d9fb2a547cd8e6bb75c0ecf427a139a9"

inherit allarch

CREATE_SRCIPK = "1"
SRCIPK_INSTALL_DIR = "board-support/board-port-labs"

PR = "r3"

REPOS ?= "git://gitorious.org/sitara-board-port/sitara-board-port-linux.git \
          git://gitorious.org/sitara-board-port/sitara-board-port-uboot.git \
         "

S = "${WORKDIR}"

# Checkout the REPOS before the do_patch task so that it will be done prior
# to the srcipk being made.
do_repos_checkout() {
    cd ${S}
    for r in ${REPOS}
    do
        git clone $r
    done
}

addtask repos_checkout after do_fetch before do_patch
