DESCRIPTION = "Task to install graphics sources in SDK"
LICENSE = "MIT"
PR = "r1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

GRAPHICS_RDEPENDS = ""

GRAPHICS_RDEPENDS_append_ti33x = " omap3-sgx-modules-src"
GRAPHICS_RDEPENDS_append_ti43x = " omap3-sgx-modules-src"

RDEPENDS_${PN} = "\
    ${GRAPHICS_RDEPENDS} \
"
