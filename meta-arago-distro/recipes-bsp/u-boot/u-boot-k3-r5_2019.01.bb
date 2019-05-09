require recipes-bsp/u-boot/u-boot-ti-staging_${PV}.bb

PROVIDES = ""
PKG_${PN} = "${PN}"
PKG_${PN}-dev = "${PN}-dev"
PKG_${PN}-dbg = "${PN}-dbg"

COMPATIBLE_MACHINE = "k3"

CROSS_COMPILE_V7 = "${@['${TARGET_SYS}-','${ELT_TARGET_SYS_ARMV7}-'][d.getVar('TOOLCHAIN_TYPE') == 'external' and d.getVar('TOOLCHAIN_BRAND') == 'linaro']}"
CROSS_COMPILE_V7 = "${@['${TARGET_SYS}-','${EAT_TARGET_SYS_ARMV7}-'][d.getVar('TOOLCHAIN_TYPE') == 'external' and d.getVar('TOOLCHAIN_BRAND') == 'arm']}"
PATH_prepend = "${TOOLCHAIN_PATH_ARMV7}/bin:"

UBOOT_MACHINE_am65xx-evm = "am65x_evm_r5_defconfig"
UBOOT_MACHINE_am65xx-hs-evm = "am65x_hs_evm_r5_defconfig"

EXTRA_OEMAKE = 'ARCH=arm CROSS_COMPILE=${CROSS_COMPILE_V7} CC="${CROSS_COMPILE_V7}gcc ${TOOLCHAIN_OPTIONS}" V=1'
EXTRA_OEMAKE += 'HOSTCC="${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS}"'

UBOOT_BINARY = "tiboot3.bin"
UBOOT_IMAGE = "tiboot3-${MACHINE}-${PV}-${PR}.bin"
UBOOT_SYMLINK = "tiboot3-${MACHINE}.bin"
SPL_BINARY_k3 = ""
