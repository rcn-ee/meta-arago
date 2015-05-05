DESCRIPTION = "Host packages for a standalone Arago SDK or external toolchain"
PR = "r7"
LICENSE = "MIT"

inherit nativesdk packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

EXTRA_TOOLS = ""
EXTRA_TOOLS_omap-a15 = "nativesdk-ti-cgt6x"

RDEPENDS_${PN} = "\
    nativesdk-pkgconfig \
    nativesdk-opkg \
    nativesdk-libtool \
    nativesdk-python-distutils \
    nativesdk-git \
    ${EXTRA_TOOLS} \
    "
