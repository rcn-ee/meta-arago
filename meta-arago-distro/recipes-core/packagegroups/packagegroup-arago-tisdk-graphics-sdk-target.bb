DESCRIPTION = "Task to install graphics binaries on sdk target"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r1"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"
ALLOW_EMPTY = "1"

GRAPHICS_RDEPENDS = ""

GRAPHICS_RDEPENDS_ti33x = "\
    libgles-omap3-dev \
"
GRAPHICS_RDEPENDS_omap3 = "\
    libgles-omap3-dev \
"

RDEPENDS_${PN} = "\
    ${GRAPHICS_RDEPENDS} \
"
