DESCRIPTION = "Host Arago SDK package for cross canadian toolchain"
PN = "packagegroup-arago-cross-canadian-${TRANSLATED_TARGET_ARCH}"
PR = "r4"
LICENSE = "MIT"

inherit cross-canadian packagegroup

RDEPENDS_${PN} = "\
    binutils-cross-canadian-${TRANSLATED_TARGET_ARCH} \
    gcc-cross-canadian-${TRANSLATED_TARGET_ARCH} \
    gdb-cross-canadian-${TRANSLATED_TARGET_ARCH} \
    "

#    meta-environment-${TRANSLATED_TARGET_ARCH}
