DESCRIPTION = "Task to install graphics binaries"
LICENSE = "MIT"
PR = "r18"

inherit packagegroup

GRAPHICS_WESTON = "\
    weston \
    weston-init \
    weston-examples \
"

GRAPHICS_RDEPENDS = "\
    libgbm \
    ti-sgx-ddk-km \
    ti-sgx-ddk-um \
"


GRAPHICS_RDEPENDS_append_omap-a15 = "\
    ti-gc320-tests \
    ti-gc320-driver \
    ti-gc320-libs  \
"

GRAPHICS_DISPLAY_UTILS = "\
    glsdk-util-scripts \
"

RDEPENDS_${PN} = "\
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', "${GRAPHICS_WESTON}", '', d)} \
    ${GRAPHICS_RDEPENDS} \
    ${GRAPHICS_DISPLAY_UTILS} \
"
