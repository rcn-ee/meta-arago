inherit cross-canadian

require external-arago-toolchain.inc

PR = "r2"

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_DEFAULT_DEPS = "1"
EXCLUDE_FROM_SHLIBS = "1"

# License applies to this recipe code, not the toolchain itself
LICENSE = "MIT"
LIC_FILES_CHKSUM = "\
	file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
	file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420 \
"

INSANE_SKIP_gcc-cross-canadian-arm = "dev-so"
INSANE_SKIP_binutils-cross-canadian-arm = "dev-so"

PROVIDES = "\
	gcc-cross-canadian-arm \
	binutils-cross-canadian-arm \
"

PACKAGES = "\
	gcc-cross-canadian-arm \
	binutils-cross-canadian-arm \
"

# Don't need the extra target triplet in the new SDK dir structure
bindir = "${exec_prefix}/bin/"
libdir = "${exec_prefix}/lib/"
libexecdir = "${exec_prefix}/libexec/"

gcclibdir = "${libdir}/gcc"

FILES_gcc-cross-canadian-arm = "\
	${prefix}/${ARAGO_TARGET_SYS}/bin/cpp \
	${prefix}/${ARAGO_TARGET_SYS}/bin/cc \
	${prefix}/${ARAGO_TARGET_SYS}/bin/gccbug \
	${prefix}/${ARAGO_TARGET_SYS}/bin/g++ \
	${prefix}/${ARAGO_TARGET_SYS}/bin/gcov \
	${prefix}/${ARAGO_TARGET_SYS}/bin/gcc \
	${prefix}/${ARAGO_TARGET_SYS}/lib/libstdc++.* \
	${prefix}/${ARAGO_TARGET_SYS}/lib/libssp* \
	${prefix}/${ARAGO_TARGET_SYS}/lib/libgcc_s.* \
	${prefix}/${ARAGO_TARGET_SYS}/lib/libsupc++.* \
	${gcclibdir}/${ARAGO_TARGET_SYS}/${ARG_VER_GCC}/* \
	${bindir}/${TARGET_PREFIX}gcov \
	${bindir}/${TARGET_PREFIX}gccbug \
	${bindir}/${TARGET_PREFIX}gcc \
	${bindir}/${TARGET_PREFIX}g++ \
	${bindir}/${TARGET_PREFIX}cpp \
	${libexecdir}/* \
"

FILES_binutils-cross-canadian-arm = "\
	${prefix}/${ARAGO_TARGET_SYS}/bin/ld \
	${prefix}/${ARAGO_TARGET_SYS}/bin/addr2line \
	${prefix}/${ARAGO_TARGET_SYS}/bin/objcopy \
	${prefix}/${ARAGO_TARGET_SYS}/bin/readelf \
	${prefix}/${ARAGO_TARGET_SYS}/bin/strip \
	${prefix}/${ARAGO_TARGET_SYS}/bin/nm \
	${prefix}/${ARAGO_TARGET_SYS}/bin/ranlib \
	${prefix}/${ARAGO_TARGET_SYS}/bin/gprof \
	${prefix}/${ARAGO_TARGET_SYS}/bin/as \
	${prefix}/${ARAGO_TARGET_SYS}/bin/c++filt \
	${prefix}/${ARAGO_TARGET_SYS}/bin/ar \
	${prefix}/${ARAGO_TARGET_SYS}/bin/strings \
	${prefix}/${ARAGO_TARGET_SYS}/bin/objdump \
	${prefix}/${ARAGO_TARGET_SYS}/bin/size \
	${includedir}/*.h \
	${libdir}/ldscripts/* \
	${libdir}/libiberty.a \
	${bindir}/${TARGET_PREFIX}ld \
	${bindir}/${TARGET_PREFIX}addr2line \
	${bindir}/${TARGET_PREFIX}objcopy \
	${bindir}/${TARGET_PREFIX}readelf \
	${bindir}/${TARGET_PREFIX}strip \
	${bindir}/${TARGET_PREFIX}nm \
	${bindir}/${TARGET_PREFIX}ranlib \
	${bindir}/${TARGET_PREFIX}gprof \
	${bindir}/${TARGET_PREFIX}as \
	${bindir}/${TARGET_PREFIX}c++filt \
	${bindir}/${TARGET_PREFIX}ar \
	${bindir}/${TARGET_PREFIX}strings \
	${bindir}/${TARGET_PREFIX}objdump \
	${bindir}/${TARGET_PREFIX}size \
	${prefix}/i686-linux/* \
"

DESCRIPTION_gcc-cross-canadian-arm = "The GNU cc and gcc C compilers"
DESCRIPTION_binutils-cross-canadian-arm = "A GNU collection of binary utilities"

LICENSE = "${ARG_LIC_LIBC}"
LICENSE_gcc-cross-canadian-arm = "${ARG_LIC_GCC}"
LICENSE_binutils-cross-canadian-arm = "${ARG_LIC_BFD}"

PKGV = "${ARG_VER_MAIN}"
PKGV_gcc-cross-canadian-arm = "${ARG_VER_GCC}"
PKGV_binutils-cross-canadian-arm = "${ARG_VER_BFD}"

do_install() {
	install -d ${D}${prefix}/${ARAGO_TARGET_SYS}/bin
	install -d ${D}${prefix}/${ARAGO_TARGET_SYS}/lib
	install -d ${D}${bindir}
	install -d ${D}${libdir}
	install -d ${D}${libdir}/ldscripts
	install -d ${D}${includedir}
	install -d ${D}${libexecdir}
	install -d ${D}${gcclibdir}/${ARAGO_TARGET_SYS}/${ARG_VER_GCC}/include
	install -d ${D}${prefix}/i686-linux

	cp -a ${TOOLCHAIN_PATH}/${ARAGO_TARGET_SYS}/bin/{cpp,cc,gccbug,g++,gcov,gcc} ${D}${prefix}/${ARAGO_TARGET_SYS}/bin
	cp -a ${TOOLCHAIN_PATH}/${ARAGO_TARGET_SYS}/lib/{libstdc++.*,libssp*,libgcc_s.*,libsupc++.*} ${D}${prefix}/${ARAGO_TARGET_SYS}/lib
	cp -a ${TOOLCHAIN_PATH}/lib/gcc/${ARAGO_TARGET_SYS}/${ARG_VER_GCC}/* ${D}${gcclibdir}/${ARAGO_TARGET_SYS}/${ARG_VER_GCC}
	cp -a ${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}{gcov,gccbug,gcc,g++,cpp} ${D}${bindir}
	cp -a ${TOOLCHAIN_PATH}/libexec/* ${D}${libexecdir}

	cp -a ${TOOLCHAIN_PATH}/${ARAGO_TARGET_SYS}/bin/{ld,addr2line,objcopy,readelf,strip,nm,ranlib,gprof,as,c++filt,ar,strings,objdump,size} ${D}${prefix}/${ARAGO_TARGET_SYS}/bin
	cp -a ${TOOLCHAIN_PATH}/include/*.h ${D}${includedir}
	cp -a ${TOOLCHAIN_PATH}/lib/ldscripts/* ${D}${libdir}/ldscripts
	cp -a ${TOOLCHAIN_PATH}/lib/libiberty.a ${D}${libdir}
	cp -a ${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}{ld,addr2line,objcopy,readelf,strip,nm,ranlib,gprof,as,c++filt,ar,strings,objdump,size} ${D}${bindir}
	cp -a ${TOOLCHAIN_PATH}/i686-linux/* ${D}${prefix}/i686-linux
}

NATIVE_INSTALL_WORKS = "1"
