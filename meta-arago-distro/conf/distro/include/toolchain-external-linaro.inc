# Select external binary prebuilt Linaro toolchain
TCMODE = "external-linaro"

#DEFAULTTUNE = "armv7at-neon"

# Set some vars to help locate the toolchain automatically from PATH
TOOLCHAIN_SYS := "arm-linux-gnueabi"
TOOLCHAIN_PREFIX := "${TOOLCHAIN_SYS}-"
