DESCRIPTION = "Task to install graphics sources in SDK"
LICENSE = "MIT"
PR = "r3"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

GRAPHICS_RDEPENDS = ""

GRAPHICS_RDEPENDS_append_ti33x = " omapdrm-pvr-src"
GRAPHICS_RDEPENDS_append_ti43x = " omapdrm-pvr-src"

RDEPENDS_${PN} = "\
    ${GRAPHICS_RDEPENDS} \
"
