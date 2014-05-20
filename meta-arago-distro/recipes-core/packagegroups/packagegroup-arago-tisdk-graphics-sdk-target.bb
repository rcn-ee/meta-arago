DESCRIPTION = "Task to install graphics binaries on sdk target"
LICENSE = "MIT"
PR = "r4"

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

GRAPHICS_RDEPENDS_omap-a15 = "\
    libgbm-dev \
    omap5-sgx-ddk-um-linux-dev \
    "

GRAPHICS_BLTSVILLE = ""
GRAPHICS_BLTSVILLE_omap-a15 = " bltsville-dev"

RDEPENDS_${PN} = "\
    ${GRAPHICS_RDEPENDS} \
    ${GRAPHICS_BLTSVILLE} \
"
