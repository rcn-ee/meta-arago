DEPENDS =+ "flex-native"

EXTRA_DEPS = "${@['','external-linaro-toolchain-cross-${TARGET_ARCH}'][d.getVar('TOOLCHAIN_TYPE') == 'external' and d.getVar('TOOLCHAIN_BRAND') == 'linaro']}"
EXTRA_DEPS = "${@['','external-arm-toolchain-cross-${TARGET_ARCH}'][d.getVar('TOOLCHAIN_TYPE') == 'external' and d.getVar('TOOLCHAIN_BRAND') == 'arm']}"
DEPENDS += "${EXTRA_DEPS}"
