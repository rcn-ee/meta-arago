DESCRIPTION = "Screenshot"
HOMEPAGE = "https://gitorious.org/screenshot"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=5cad16cc3f514a15adb1d710b82d5fc4"
SECTION = "graphics"

PR = "r0"

BRANCH ?= "master"
SRCREV = "1f11a23be4386c2ee0387cd12c1a9569c703a3bb" 

SRC_URI = "git://gitorious.org/screenshot/screenshot.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

do_compile() {
    export CROSS_COMPILE=${TARGET_PREFIX}
    export ARCH=${ARMPKGARCH}
    # build the release version
    make release
}

do_install() {
    export ARCH=${ARMPKGARCH}
    make DESTDIR=${D} install
}
