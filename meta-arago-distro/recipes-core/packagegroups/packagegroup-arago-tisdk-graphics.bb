DESCRIPTION = "Task to install graphics binaries"
LICENSE = "MIT"
PR = "r19"

inherit packagegroup

GRAPHICS_WAYLAND = "\
    weston \
    weston-init \
    weston-examples \
    wayland-ivi-extension \
"

GRAPHICS_WAYLAND_append_omap-a15 = "\
    chromium-wayland \
"

GRAPHICS_RDEPENDS = "\
    libgbm \
    ti-sgx-ddk-km \
    ti-sgx-ddk-um \
    glmark2 \
"

GRAPHICS_DISPLAY_UTILS = "\
"

GRAPHICS_DISPLAY_UTILS_append_omap-a15  = "\
    glsdk-util-scripts \
"

GRAPHICS_RDEPENDS_append_omap-a15 = "\
    ti-gc320-tests \
    ti-gc320-driver \
    ti-gc320-libs  \
"

RDEPENDS_${PN} = "\
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', "${GRAPHICS_WAYLAND}", '', d)} \
    ${GRAPHICS_RDEPENDS} \
    ${GRAPHICS_DISPLAY_UTILS} \
"
