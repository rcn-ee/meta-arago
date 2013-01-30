DESCRIPTION = "Host Arago SDK package for cross canadian toolchain"
PN = "packagegroup-arago-cross-canadian-${TRANSLATED_TARGET_ARCH}"
PR = "r3"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit cross-canadian packagegroup

PACKAGES = "${PN}"

RDEPENDS_${PN} = "\
    binutils-cross-canadian-${TRANSLATED_TARGET_ARCH} \
    gcc-cross-canadian-${TRANSLATED_TARGET_ARCH} \
    gdb-cross-canadian-${TRANSLATED_TARGET_ARCH} \
    "

#    meta-environment-${TRANSLATED_TARGET_ARCH}
