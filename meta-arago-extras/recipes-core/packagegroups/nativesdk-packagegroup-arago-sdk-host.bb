DESCRIPTION = "Host packages for a standalone Arago SDK or external toolchain"
PR = "r6"
LICENSE = "MIT"

inherit nativesdk packagegroup

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
