DESCRIPTION = "Task to install graphics sources in SDK"
LICENSE = "MIT"
PR = "r0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

GRAPHICS_RDEPENDS = ""

GRAPHICS_RDEPENDS_append_ti33x = " omap3-sgx-modules-src"
GRAPHICS_RDEPENDS_append_ti43x = " omap3-sgx-modules-src"

RDEPENDS_${PN} = "\
    ${GRAPHICS_RDEPENDS} \
"
