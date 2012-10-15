DESCRIPTION = "Host packages for a standalone Arago SDK or external toolchain"
PR = "r0"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit nativesdk

PACKAGES = "${PN}"

RDEPENDS_${PN} = "\
    pkgconfig-nativesdk \
    opkg-nativesdk \
    libtool-nativesdk \
    autoconf-nativesdk \
    automake-nativesdk \
    "
