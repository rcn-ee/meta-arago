DESCRIPTION = "Task to install graphics binaries on sdk target"
LICENSE = "MIT"
PR = "r6"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

GRAPHICS_RDEPENDS = ""

GRAPHICS_RDEPENDS_ti33x = "\
    libgbm-dev \
    omap5-sgx-ddk-um-linux-dev \
    "

GRAPHICS_RDEPENDS_omap3 = "\
    libgles-omap3-dev \
"

GRAPHICS_RDEPENDS_ti43x = "\
    libgbm-dev \
    omap5-sgx-ddk-um-linux-dev \
    "

GRAPHICS_RDEPENDS_omap-a15 = "\
    libgbm-dev \
    omap5-sgx-ddk-um-linux-dev \
    "

RDEPENDS_${PN} = "\
    ${GRAPHICS_RDEPENDS} \
"
