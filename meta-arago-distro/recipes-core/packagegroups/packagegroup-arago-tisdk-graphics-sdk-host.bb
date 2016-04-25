DESCRIPTION = "Task to install graphics sources in SDK"
LICENSE = "MIT"
PR = "r5"

inherit packagegroup

GRAPHICS_RDEPENDS = "ti-sgx-ddk-km-src"

RDEPENDS_${PN} = "\
    ${GRAPHICS_RDEPENDS} \
"
