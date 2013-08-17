SUMMARY = "Host Arago SDK package for cross canadian toolchain"
PN = "packagegroup-arago-cross-canadian-${TRANSLATED_TARGET_ARCH}"
PR = "r5"
LICENSE = "MIT"

# Save TRANSLATED_TARGET_ARCH before allarch tramples it
TRANSLATED_TARGET_ARCH = "${@d.getVar('TUNE_ARCH', True).replace('_', '-')}"

inherit cross-canadian packagegroup

PACKAGEGROUP_DISABLE_COMPLEMENTARY = "1"

RDEPENDS_${PN} = "\
    binutils-cross-canadian-${TRANSLATED_TARGET_ARCH} \
    gcc-cross-canadian-${TRANSLATED_TARGET_ARCH} \
    gdb-cross-canadian-${TRANSLATED_TARGET_ARCH} \
    "

#    meta-environment-${TRANSLATED_TARGET_ARCH}
