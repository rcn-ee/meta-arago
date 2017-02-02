DESCRIPTION = "Task to install graphics sources in SDK"
LICENSE = "MIT"
PR = "r6"

inherit packagegroup

GRAPHICS_RDEPENDS = "ti-sgx-ddk-km-src"

GRAPHICS_RDEPENDS_append_omap-a15 = "\
    ti-gc320-driver-src \
"

RDEPENDS_${PN} = "\
    ${GRAPHICS_RDEPENDS} \
"
