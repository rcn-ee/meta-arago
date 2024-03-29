# Select internal gcc toolchain to be built from sources
TCMODE = "default"
TCLIBC = "glibc"

LIBCEXTENSION = "${@['', '-gnu'][(d.getVar('ABIEXTENSION') or '') != '']}"

# Match some of the external vars
TOOLCHAIN_SYS := "${TARGET_SYS}"
TOOLCHAIN_PREFIX := "${TARGET_PREFIX}"

PREFERRED_PROVIDER_gcc-cross-canadian-${TRANSLATED_TARGET_ARCH} ?= "gcc-cross-canadian-${TRANSLATED_TARGET_ARCH}"
PREFERRED_PROVIDER_binutils-cross-canadian-${TRANSLATED_TARGET_ARCH} ?= "binutils-cross-canadian-${TRANSLATED_TARGET_ARCH}"
PREFERRED_PROVIDER_gdb-cross-canadian-${TRANSLATED_TARGET_ARCH} = "gdb-cross-canadian-${TRANSLATED_TARGET_ARCH}"

# Set Cross and SDK toolchain preferences
SDKGCCVERSION ?= "13%"
SDKBINUVERSION ?= "2.40%"
SDKGLIBCVERSION ?= "2.37%"

PREFERRED_VERSION_gcc-crosssdk-${SDK_SYS} ?= "${SDKGCCVERSION}"
PREFERRED_VERSION_gcc-crosssdk-initial-${SDK_SYS} ?= "${SDKGCCVERSION}"
PREFERRED_VERSION_binutils-crosssdk-${SDK_SYS} ?= "${SDKBINUVERSION}"

PREFERRED_VERSION_nativesdk-gcc-runtime ?= "${SDKGCCVERSION}"
PREFERRED_VERSION_nativesdk-libgcc ?= "${SDKGCCVERSION}"
PREFERRED_VERSION_nativesdk-libgcc-initial ?= "${SDKGCCVERSION}"
PREFERRED_VERSION_nativesdk-glibc ?= "${SDKGLIBCVERSION}"
PREFERRED_VERSION_nativesdk-glibc-locale ?= "${SDKGLIBCVERSION}"
PREFERRED_VERSION_nativesdk-glibc-initial ?= "${SDKGLIBCVERSION}"

# Set target toolchain preferences to match Cross/SDK by default
# Can be overwritten globally, if needed
GCCVERSION ?= "13%"
BINUVERSION ?= "2.40%"
GLIBCVERSION ?= "2.37%"

PREFERRED_VERSION_gcc ?= "${GCCVERSION}"
PREFERRED_VERSION_binutils ?= "${BINUVERSION}"
PREFERRED_VERSION_glibc ?= "${GLIBCVERSION}"
PREFERRED_VERSION_glibc-locale ?= "${GLIBCVERSION}"
PREFERRED_VERSION_glibc-initial ?= "${GLIBCVERSION}"
