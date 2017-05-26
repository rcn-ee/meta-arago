SUMMARY = "Host Arago SDK package for cross canadian toolchain"
PN = "packagegroup-arago-cross-canadian-${MACHINE}"
PR = "r7"

inherit cross-canadian packagegroup

PACKAGEGROUP_DISABLE_COMPLEMENTARY = "1"

# Use indirection to stop these being expanded prematurely
BINUTILS = "binutils-cross-canadian-${TRANSLATED_TARGET_ARCH}"
GCC = "gcc-cross-canadian-${TRANSLATED_TARGET_ARCH}"
GDB = "gdb-cross-canadian-${TRANSLATED_TARGET_ARCH}"

RDEPENDS_${PN} = "\
    ${@all_multilib_tune_values(d, 'BINUTILS')} \
    ${@all_multilib_tune_values(d, 'GCC')} \
    ${@all_multilib_tune_values(d, 'GDB')} \
    "

#    meta-environment-${MACHINE}
