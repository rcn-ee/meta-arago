# Select external binary prebuilt Arago toolchain
TCMODE = "external-arago"
TCLIBC = "external-arago-toolchain"

#DEFAULTTUNE = "armv7at-neon"

# Set some vars to help locate the toolchain automatically from PATH
TOOLCHAIN_SYS := "arm-arago-linux-gnueabi"
TOOLCHAIN_PREFIX := "${TOOLCHAIN_SYS}-"
