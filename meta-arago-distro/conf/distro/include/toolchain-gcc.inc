# Select internal gcc toolchain to be built from sources
TCMODE = "default"
TCLIBC = "glibc"

LIBCEXTENSION = "${@['', '-gnu'][(d.getVar('ABIEXTENSION', True) or '') != '']}"

# Match some of the external vars
TOOLCHAIN_SYS := "${TARGET_SYS}"
TOOLCHAIN_PREFIX := "${TARGET_PREFIX}"

bindir_pn-gcc-cross-canadian-${TRANSLATED_TARGET_ARCH} = "${exec_prefix}/bin"
bindir_pn-binutils-cross-canadian-${TRANSLATED_TARGET_ARCH} = "${exec_prefix}/bin"
bindir_pn-gdb-cross-canadian-${TRANSLATED_TARGET_ARCH} = "${exec_prefix}/bin"

PREFERRED_PROVIDER_gcc-cross-canadian-${TRANSLATED_TARGET_ARCH} ?= "gcc-cross-canadian-${TRANSLATED_TARGET_ARCH}"
PREFERRED_PROVIDER_binutils-cross-canadian-${TRANSLATED_TARGET_ARCH} ?= "binutils-cross-canadian-${TRANSLATED_TARGET_ARCH}"
PREFERRED_PROVIDER_gdb-cross-canadian-${TRANSLATED_TARGET_ARCH} = "gdb-cross-canadian-${TRANSLATED_TARGET_ARCH}"

SDKGCCVERSION ?= "5.3%"
SDKBINUVERSION ?= "2.26%"
SDKGLIBCVERSION ?= "2.23%"
SDKLINUXLIBCVERSION ?= "4.4%"

PREFERRED_VERSION_gcc-crosssdk ?= "${SDKGCCVERSION}"
PREFERRED_VERSION_gcc-crosssdk-initial ?= "${SDKGCCVERSION}"
PREFERRED_VERSION_gcc-crosssdk-intermediate ?= "${SDKGCCVERSION}"
PREFERRED_VERSION_nativesdk-gcc-runtime ?= "${SDKGCCVERSION}"
PREFERRED_VERSION_nativesdk-libgcc ?= "${SDKGCCVERSION}"
PREFERRED_VERSION_binutils-crosssdk ?= "${SDKBINUVERSION}"
PREFERRED_VERSION_nativesdk-linux-libc-headers ?= "${SDKLINUXLIBCVERSION}"
PREFERRED_VERSION_nativesdk-glibc ?= "${SDKGLIBCVERSION}"
PREFERRED_VERSION_nativesdk-glibc-initial ?= "${SDKGLIBCVERSION}"
