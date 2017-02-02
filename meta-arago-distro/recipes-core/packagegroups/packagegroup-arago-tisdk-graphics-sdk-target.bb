DESCRIPTION = "Task to install graphics binaries on sdk target"
LICENSE = "MIT"
PR = "r8"

inherit packagegroup

GRAPHICS_RDEPENDS = "\
    libgbm-dev \
    ti-sgx-ddk-um-dev \
    "

GRAPHICS_RDEPENDS_append_omap-a15 = "\
    ti-gc320-libs-dev \
"

RDEPENDS_${PN} = "\
    ${GRAPHICS_RDEPENDS} \
"
