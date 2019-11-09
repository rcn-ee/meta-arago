DESCRIPTION = "Task to install graphics binaries"
LICENSE = "MIT"
PR = "r26"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

GRAPHICS_WAYLAND = "\
    weston \
    weston-init \
    weston-examples \
    wayland-ivi-extension \
"

GRAPHICS_WAYLAND_append_omap-a15 = "\
    ${@bb.utils.contains('MACHINE_FEATURES','gpu','chromium-ozone-wayland','',d)} \
"

GRAPHICS_WAYLAND_append_k3 = "\
    ${@bb.utils.contains('MACHINE_FEATURES','gpu','chromium-ozone-wayland','',d)} \
"

GRAPHICS_RDEPENDS = "\
    ${PREFERRED_PROVIDER_virtual/libgbm} \
    ${PREFERRED_PROVIDER_virtual/egl} \
    ${@bb.utils.contains('MACHINE_FEATURES','gpu','${PREFERRED_PROVIDER_virtual/gpudriver}','',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES','gpu','glmark2','',d)} \
"
GRAPHICS_RDEPENDS_remove_j7-evm = "ti-sgx-ddk-km"

GRAPHICS_DISPLAY_UTILS = "\
"

GRAPHICS_DISPLAY_UTILS_append_omap-a15  = "\
    ${@bb.utils.contains('MACHINE_FEATURES','gpu','glsdk-util-scripts','',d)} \
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
