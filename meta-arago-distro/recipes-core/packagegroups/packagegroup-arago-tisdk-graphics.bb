DESCRIPTION = "Task to install graphics binaries"
LICENSE = "MIT"
PR = "r2"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

GRAPHICS_SDK = "\
    libgles-omap3 \
    libgles-omap3-blitwsegl \
    libgles-omap3-flipwsegl \
    libgles-omap3-frontwsegl \
    libgles-omap3-linuxfbwsegl \
    libgles-omap3-rawdemos \
    omap3-sgx-modules \
"

GRAPHICS_RDEPENDS = ""

GRAPHICS_RDEPENDS_ti33x = "\
    ${GRAPHICS_SDK} \
"

GRAPHICS_RDEPENDS_omap3 = "\
    ${GRAPHICS_SDK} \
"

RDEPENDS_${PN} = "\
    ${GRAPHICS_RDEPENDS} \
"
