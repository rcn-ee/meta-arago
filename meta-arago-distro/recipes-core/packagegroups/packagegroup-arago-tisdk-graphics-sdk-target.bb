DESCRIPTION = "Task to install graphics binaries on sdk target"
LICENSE = "MIT"
PR = "r9"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

GRAPHICS_RDEPENDS = "\
    libgbm-dev \
    libdrm-dev \
    wayland-dev \
    weston-dev \
    ${PREFERRED_PROVIDER_virtual/egl}-dev \
    ti-sgx-ddk-km-dev \
"
GRAPHICS_RDEPENDS_remove_j7-evm = "ti-sgx-ddk-km-dev"

GRAPHICS_RDEPENDS_append_omap-a15 = "\
    ti-gc320-libs-dev \
"

RDEPENDS_${PN} = "\
    ${GRAPHICS_RDEPENDS} \
"
