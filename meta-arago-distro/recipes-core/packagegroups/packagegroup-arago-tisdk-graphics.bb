DESCRIPTION = "Task to install graphics binaries"
LICENSE = "MIT"
PR = "r13"

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

RDEPENDS_${PN} = "\
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', "${GRAPHICS_WESTON}", '', d)} \
    ${GRAPHICS_RDEPENDS} \
"
