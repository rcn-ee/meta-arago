# Select external binary prebuilt Linaro toolchain
TCMODE = "external-linaro"
TCLIBC = "external-linaro-toolchain"

ELT_TARGET_SYS = "arm-linux-gnueabi"
#DEFAULTTUNE = "armv7at-neon"

# Set some vars to help locate the toolchain automatically from PATH
TOOLCHAIN_SYS := "arm-linux-gnueabi"
TOOLCHAIN_PREFIX := "${TOOLCHAIN_SYS}-"

PREFERRED_PROVIDER_gcc-cross-canadian-${TRANSLATED_TARGET_ARCH} ?= "gcc-cross-canadian-arm"
PREFERRED_PROVIDER_binutils-cross-canadian-${TRANSLATED_TARGET_ARCH} ?= "binutils-cross-canadian-arm"
PREFERRED_PROVIDER_gdb-cross-canadian-${TRANSLATED_TARGET_ARCH} = "gdb-cross-canadian-arm"
