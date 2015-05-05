DESCRIPTION = "Host packages for a standalone Arago SDK or external toolchain"
PR = "r8"
LICENSE = "MIT"

inherit nativesdk packagegroup

EXTRA_TOOLS = "nativesdk-ti-cgt6x"

RDEPENDS_${PN} = "\
    nativesdk-pkgconfig \
    nativesdk-opkg \
    nativesdk-libtool \
    nativesdk-python-distutils \
    nativesdk-git \
    ${EXTRA_TOOLS} \
    "
