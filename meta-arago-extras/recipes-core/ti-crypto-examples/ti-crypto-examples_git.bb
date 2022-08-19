DESCRIPTION = "TI Cryptography Example Applications"
HOMEPAGE = "https://git.ti.com/cgit/arago-project-org/crypto-example-apps/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://AES/aes_256.c;beginline=9;endline=35;md5=8edbb4dee965d2f2eb5ca2822addcae5"
SECTION = "console"
DEPENDS += "openssl"

PR = "r7"

BRANCH ?= "master"
SRCREV = "6f4b09fffe970bb6b448369875874e798ef282f6"

SRC_URI = "git://git.ti.com/git/git/arago-project-org/crypto-example-apps.git;protocol=https;branch=${BRANCH}"

S = "${WORKDIR}/git/"

do_compile() {
    export CROSS_COMPILE=${TARGET_PREFIX}
    export CFLAGS='${TARGET_CC_ARCH}'
    # build the release version
    oe_runmake release
}

do_install() {
    oe_runmake DESTDIR=${D} install
}

python () {
    raise bb.parse.SkipRecipe("skipping ti-crypto-examples")
}
