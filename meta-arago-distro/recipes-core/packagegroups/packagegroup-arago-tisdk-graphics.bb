DESCRIPTION = "Task to install graphics binaries"
LICENSE = "MIT"
PR = "r24"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

#    wayland-ivi-extension
GRAPHICS_WAYLAND = "\
    weston \
    weston-init \
    weston-examples \
"

GRAPHICS_WAYLAND_append_omap-a15 = "\
    ${@bb.utils.contains('MACHINE_FEATURES','sgx','chromium-wayland','',d)} \
"

GRAPHICS_WAYLAND_append_k3 = "\
    ${@bb.utils.contains('MACHINE_FEATURES','sgx','chromium-wayland','',d)} \
"

GRAPHICS_RDEPENDS = "\
    libgbm \
    ${PREFERRED_PROVIDER_virtual/egl} \
    ${@bb.utils.contains('MACHINE_FEATURES','sgx','ti-sgx-ddk-km','',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES','sgx','glmark2','',d)} \
"
GRAPHICS_RDEPENDS_remove_j7-evm = "ti-sgx-ddk-km"

GRAPHICS_DISPLAY_UTILS = "\
"

GRAPHICS_DISPLAY_UTILS_append_omap-a15  = "\
    ${@bb.utils.contains('MACHINE_FEATURES','sgx','glsdk-util-scripts','',d)} \
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
