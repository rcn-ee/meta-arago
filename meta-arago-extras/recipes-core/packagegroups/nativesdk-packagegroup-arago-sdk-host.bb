DESCRIPTION = "Host packages for a standalone Arago SDK or external toolchain"
PR = "r3"
LICENSE = "MIT"

inherit nativesdk packagegroup

RDEPENDS_${PN} = "\
    nativesdk-pkgconfig \
    nativesdk-opkg \
    nativesdk-libtool \
    "
