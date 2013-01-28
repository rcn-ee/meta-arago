DESCRIPTION = "TI Cryptography Example Applications"
HOMEPAGE = "http://arago-project.org/git/projects/?p=crypto-example-apps.git;a=summary"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://AES/aes_256.c;beginline=9;endline=35;md5=8edbb4dee965d2f2eb5ca2822addcae5"
SECTION = "console"
DEPENDS += "openssl"

PR = "r2"

BRANCH ?= "master"
SRCREV = "37aad72a4d49d0a6dbe934495e5c3bd973a72f1a"

SRC_URI = "git://arago-project.org/git/projects/crypto-example-apps.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

do_compile() {
    # build the release version
    oe_runmake release
}

do_install() {
    oe_runmake DESTDIR=${D} install
}
