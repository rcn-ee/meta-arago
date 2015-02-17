DESCRIPTION = "Host packages for a standalone Arago SDK or external toolchain"
PR = "r5"
LICENSE = "MIT"

inherit nativesdk packagegroup

RDEPENDS_${PN} = "\
    nativesdk-pkgconfig \
    nativesdk-opkg \
    nativesdk-libtool \
    nativesdk-python-distutils \
    nativesdk-git \
    "
