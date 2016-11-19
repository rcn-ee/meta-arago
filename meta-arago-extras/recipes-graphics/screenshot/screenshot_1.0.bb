SUMMARY = "Screenshot"
HOMEPAGE = "https://gitorious.org/screenshot"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=5cad16cc3f514a15adb1d710b82d5fc4"
SECTION = "graphics"

PR = "r2"

BRANCH ?= "master"
SRCREV = "169242aa7a265d5c94755d74601ad4a3f1828c96"

SRC_URI = "git://git.ti.com/apps/screenshot.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

do_compile() {
    export CROSS_COMPILE=${TARGET_PREFIX}
    export CFLAGS='${TARGET_CC_ARCH}'
    # build the release version
    make release CC="${CC}"
}

do_install() {
    make DESTDIR=${D} install
}
