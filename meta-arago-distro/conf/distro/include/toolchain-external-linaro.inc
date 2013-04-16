# Select external binary prebuilt Linaro toolchain
TCMODE = "external-linaro"
TCLIBC = "external-linaro-toolchain"

ELT_TARGET_SYS = "arm-linux-gnueabihf"
DEFAULTTUNE = "cortexa8thf-neon"
DEFAULTTUNE_omap-a15 = "cortexa15thf-neon"
DEFAULTTUNE_keystone = "cortexa15thf-neon"
DEFAULTTUNE_omap4 = "cortexa9thf-neon"

PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}gcc-intermediate = "external-linaro-toolchain"

# Set some vars to help locate the toolchain automatically from PATH
TOOLCHAIN_SYS := "${ELT_TARGET_SYS}"
TOOLCHAIN_PREFIX := "${TOOLCHAIN_SYS}-"

PREFERRED_PROVIDER_gcc-cross-canadian-${TRANSLATED_TARGET_ARCH} ?= "external-linaro-sdk-toolchain"
PREFERRED_PROVIDER_binutils-cross-canadian-${TRANSLATED_TARGET_ARCH} ?= "external-linaro-sdk-toolchain"
#PREFERRED_PROVIDER_gdb-cross-canadian-${TRANSLATED_TARGET_ARCH} = "external-linaro-sdk-toolchain"

# Special case for gdb to be built as part of canadian-cross-sdk, instead of packaged from external toolchain
PREFERRED_PROVIDER_gdb-cross-canadian-${TRANSLATED_TARGET_ARCH} = "gdb-cross-canadian-${TRANSLATED_TARGET_ARCH}"

SDKGCCVERSION ?= "4.7%"
SDKBINUVERSION ?= "2.22%"
SDKEGLIBCVERSION ?= "2.16%"
SDKLINUXLIBCVERSION ?= "3.2"

PREFERRED_VERSION_gcc-crosssdk ?= "${SDKGCCVERSION}"
PREFERRED_VERSION_gcc-crosssdk-initial ?= "${SDKGCCVERSION}"
PREFERRED_VERSION_gcc-crosssdk-intermediate ?= "${SDKGCCVERSION}"
PREFERRED_VERSION_nativesdk-gcc-runtime ?= "${SDKGCCVERSION}"
PREFERRED_VERSION_nativesdk-libgcc ?= "${SDKGCCVERSION}"
PREFERRED_VERSION_binutils-crosssdk ?= "${SDKBINUVERSION}"
PREFERRED_VERSION_nativesdk-linux-libc-headers ?= "${SDKLINUXLIBCVERSION}"
PREFERRED_VERSION_nativesdk-eglibc ?= "${SDKEGLIBCVERSION}"
PREFERRED_VERSION_nativesdk-eglibc-initial ?= "${SDKEGLIBCVERSION}"
