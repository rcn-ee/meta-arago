DESCRIPTION = "Diagnostic tool for TI OMAP processors"
HOMEPAGE = "https://github.com/omapconf/omapconf"

LICENSE = "GPLv2 BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=205c83c4e2242a765acb923fc766e914"

PV = "1.68"
PR = "r0"

COMPATIBLE_MACHINE = "omap-a15|omap4"

BRANCH ?= "master"
SRCREV = "51fa0acb6ae24a9f14b11bc4b56c4f764b017f3f"

SRC_URI = "git://github.com/omapconf/omapconf.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

do_compile () {
    oe_runmake CROSS_COMPILE=${TARGET_PREFIX} install
}

do_install () {
    oe_runmake DESTDIR=${D}${bindir} install
}
