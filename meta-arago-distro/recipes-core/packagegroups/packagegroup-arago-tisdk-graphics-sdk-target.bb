DESCRIPTION = "Task to install graphics binaries on sdk target"
LICENSE = "MIT"
PR = "r7"

inherit packagegroup

GRAPHICS_RDEPENDS = "\
    libgbm-dev \
    ti-sgx-ddk-um-dev \
    "

RDEPENDS_${PN} = "\
    ${GRAPHICS_RDEPENDS} \
"
