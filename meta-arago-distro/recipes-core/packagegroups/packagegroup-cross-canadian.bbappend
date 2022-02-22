PR:append = ".arago0"

SECONDARY_TARGET_ARCH ?= "invalid"

SECONDARY_TOOLCHAIN = "gcc-cross-canadian-${SECONDARY_TARGET_ARCH} \
                       binutils-cross-canadian-${SECONDARY_TARGET_ARCH}"

RDEPENDS:${PN}:append = " \
    ${@oe.utils.conditional('SECONDARY_TARGET_ARCH', 'invalid', '', '${SECONDARY_TOOLCHAIN}', d)} \
"
