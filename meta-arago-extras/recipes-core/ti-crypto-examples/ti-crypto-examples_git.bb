DESCRIPTION = "TI Cryptography Example Applications"
HOMEPAGE = "http://arago-project.org/git/projects/?p=crypto-example-apps.git;a=summary"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://armv5te/AES/aes_256.c;beginline=9;endline=35;md5=8edbb4dee965d2f2eb5ca2822addcae5 \
                    file://armv7a/AES/aes_256.c;beginline=9;endline=35;md5=8edbb4dee965d2f2eb5ca2822addcae5"
SECTION = "console"
DEPENDS += "openssl"

PR = "r4"

BRANCH ?= "master"
SRCREV = "ade3446fda75f4e07262b6162343a1b8d85521cb"

SRC_URI = "git://arago-project.org/git/projects/crypto-example-apps.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git/"

# This software contains two directories depending on ARM architecture
SOURCE_DIR = "${S}/${ARMPKGARCH}"

# Specify armv5te for ARM9 devices
SOURCE_DIR_omapl138 = "${S}/armv5te"

do_compile() {
    cd ${SOURCE_DIR}
    export CROSS_COMPILE=${TARGET_PREFIX}
    export CFLAGS='${TARGET_CC_ARCH}'
    # build the release version
    oe_runmake release
}

do_install() {
    cd ${SOURCE_DIR}

    oe_runmake DESTDIR=${D} install
}
