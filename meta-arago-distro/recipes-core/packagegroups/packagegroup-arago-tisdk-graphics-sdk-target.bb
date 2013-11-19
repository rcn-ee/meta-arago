DESCRIPTION = "Task to install graphics binaries on sdk target"
LICENSE = "MIT"
PR = "r3"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

GRAPHICS_RDEPENDS = ""

GRAPHICS_RDEPENDS_ti33x = "\
    libgles-omap3-dev \
"
GRAPHICS_RDEPENDS_omap3 = "\
    libgles-omap3-dev \
"

GRAPHICS_RDEPENDS_ti43x = "\
    libgles-omap3-dev \
"

RDEPENDS_${PN} = "\
    ${GRAPHICS_RDEPENDS} \
"
