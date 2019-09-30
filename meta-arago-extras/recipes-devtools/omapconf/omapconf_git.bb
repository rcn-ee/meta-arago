SUMMARY = "Diagnostic tool for TI OMAP processors"
HOMEPAGE = "https://github.com/omapconf/omapconf"

LICENSE = "GPLv2 | BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=205c83c4e2242a765acb923fc766e914"

PV = "1.74"

COMPATIBLE_MACHINE = "ti33x|ti43x|omap-a15|omap4"

BRANCH ?= "master"
SRCREV = "d7a461c0d6c6bcf986f991d4bcee130562b040d6"

SRC_URI = "git://github.com/omapconf/omapconf.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

do_compile () {
    oe_runmake CC="${CC}" all
}

do_install () {
    oe_runmake DESTDIR=${D}${bindir} install
}
