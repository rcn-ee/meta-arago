DESCRIPTION = "Task to install graphics binaries"
LICENSE = "MIT"
PR = "r8"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

GRAPHICS_WESTON = "\
    weston \
    weston-init \
    weston-examples \
"

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

GRAPHICS_RDEPENDS_ti43x = "\
    ${GRAPHICS_SDK} \
"

GRAPHICS_RDEPENDS_omap3 = "\
    ${GRAPHICS_SDK} \
"

GRAPHICS_RDEPENDS_omap-a15 = "\
    libgbm \
    omap5-sgx-ddk-um-linux \
    "
# Put this back when compile issues are fixed against 3.14
#    omapdrm-pvr

RDEPENDS_${PN} = "\
    ${@base_contains('DISTRO_FEATURES', 'wayland', "${GRAPHICS_WESTON}", '', d)} \
    ${GRAPHICS_RDEPENDS} \
"
