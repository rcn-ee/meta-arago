# When external-arm toolchain is not in use, EAT_TARGET_SYS is undefined,
# causing below _append expansion to break - just weakly set it to empty
EAT_TARGET_SYS ?= ""

# grub uses --target triplet to find binutils binaries such as objcopy
# Since external-arm toolchain uses aarch64-none-linux-gnu triplet,
# OE-defined TARGET_SYS differs from EAT_TARGET_SYS used by external-arm
# toolchain, grub needs passing the correct --target to configure script
CONFIGUREOPTS_append_class-target = "${@['',' --target=${EAT_TARGET_SYS}'][d.getVar('TCMODE') == 'external-arm']}"
