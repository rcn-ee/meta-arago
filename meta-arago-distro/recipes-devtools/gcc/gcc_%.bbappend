DEPENDS =+ "flex-native"

EXTRA_DEPS = "${@['','external-linaro-toolchain-cross-${TARGET_ARCH}'][d.getVar('TOOLCHAIN_TYPE', True) == 'external' and d.getVar('TOOLCHAIN_BRAND', True) == 'linaro']}"
DEPENDS += "${EXTRA_DEPS}"
