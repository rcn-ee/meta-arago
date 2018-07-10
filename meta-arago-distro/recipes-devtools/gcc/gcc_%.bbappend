DEPENDS =+ "flex-native"

EXTRA_DEPS = "${@['','external-linaro-toolchain-cross-${TARGET_ARCH}'][d.getVar('TOOLCHAIN_TYPE') == 'external' and d.getVar('TOOLCHAIN_BRAND') == 'linaro']}"
DEPENDS += "${EXTRA_DEPS}"
