DESCRIPTION = "Host packages for a standalone Arago SDK or external toolchain"
PR = "r2"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit nativesdk packagegroup

PACKAGES = "${PN}"

RDEPENDS_${PN} = "\
    nativesdk-pkgconfig \
    nativesdk-opkg \
    nativesdk-libtool \
    "
