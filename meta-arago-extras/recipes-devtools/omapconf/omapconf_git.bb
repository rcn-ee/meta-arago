DESCRIPTION = "Diagnostic tool for TI OMAP processors"
HOMEPAGE = "https://github.com/omapconf/omapconf"

LICENSE = "GPLv2 BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=205c83c4e2242a765acb923fc766e914"

PV = "1.71+1.72-rc1"
PR = "r0"

COMPATIBLE_MACHINE = "ti33x|ti43x|omap-a15|omap4"

BRANCH ?= "master"
SRCREV = "576b01f43bcbfa15fb25b2aeb17ac3b3aa70e3d7"

SRC_URI = "git://github.com/omapconf/omapconf.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

do_compile () {
    oe_runmake CROSS_COMPILE=${TARGET_PREFIX} install
}

do_install () {
    oe_runmake DESTDIR=${D}${bindir} install
}
