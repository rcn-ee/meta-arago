PR_append = ".arago0"

SECONDARY_TARGET_ARCH ?= ""

SECONDARY_TOOLCHAIN = "gcc-cross-canadian-${SECONDARY_TARGET_ARCH} \
                       binutils-cross-canadian-${SECONDARY_TARGET_ARCH}"

RDEPENDS_${PN}_append = " \
    ${@oe.utils.conditional('SECONDARY_TARGET_ARCH', '', '', '${SECONDARY_TOOLCHAIN}', d)} \
"
