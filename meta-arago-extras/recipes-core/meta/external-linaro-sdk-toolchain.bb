inherit cross-canadian

require external-linaro-bfd-version.inc

PR = "r8"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_SYSROOT_STRIP = "1"
INHIBIT_DEFAULT_DEPS = "1"
EXCLUDE_FROM_SHLIBS = "1"

# License applies to this recipe code, not the toolchain itself
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

INSANE_SKIP_gcc-cross-canadian-${TRANSLATED_TARGET_ARCH} = "dev-so staticdev file-rdeps"
INSANE_SKIP_gdb-cross-canadian-${TRANSLATED_TARGET_ARCH} = "dev-so file-rdeps"
INSANE_SKIP_binutils-cross-canadian-${TRANSLATED_TARGET_ARCH} = "dev-so file-rdeps"

PROVIDES = "\
	gcc-cross-canadian-${TRANSLATED_TARGET_ARCH} \
	${@oe.utils.conditional('PREFERRED_PROVIDER_gdb-cross-canadian-${TRANSLATED_TARGET_ARCH}', 'external-linaro-sdk-toolchain', 'gdb-cross-canadian-${TRANSLATED_TARGET_ARCH}', '', d)} \
	binutils-cross-canadian-${TRANSLATED_TARGET_ARCH} \
"

PACKAGES = "\
	gcc-cross-canadian-${TRANSLATED_TARGET_ARCH} \
	${@oe.utils.conditional('PREFERRED_PROVIDER_gdb-cross-canadian-${TRANSLATED_TARGET_ARCH}', 'external-linaro-sdk-toolchain', 'gdb-cross-canadian-${TRANSLATED_TARGET_ARCH}', '', d)} \
	binutils-cross-canadian-${TRANSLATED_TARGET_ARCH} \
"

# Don't need the extra target triplet in the new SDK dir structure
bindir = "${exec_prefix}/bin"
libdir = "${exec_prefix}/lib"
libexecdir = "${exec_prefix}/libexec"
datadir = "${exec_prefix}/share"
gcclibdir = "${libdir}/gcc"

FILES_gcc-cross-canadian-${TRANSLATED_TARGET_ARCH} = "\
	${prefix}/${ELT_TARGET_SYS}/lib/libstdc++.* \
	${prefix}/${ELT_TARGET_SYS}/lib/libgcc_s.* \
	${prefix}/${ELT_TARGET_SYS}/lib/libsupc++.* \
	${gcclibdir}/${ELT_TARGET_SYS}/${ELT_VER_GCC}/* \
	${bindir}/${TARGET_PREFIX}gcov \
	${bindir}/${TARGET_PREFIX}gcc* \
	${bindir}/${TARGET_PREFIX}g++ \
	${bindir}/${TARGET_PREFIX}cpp \
	${libexecdir}/* \
"

FILES_gdb-cross-canadian-${TRANSLATED_TARGET_ARCH} = "\
	${bindir}/${TARGET_PREFIX}gdb \
	${bindir}/${TARGET_PREFIX}gdbtui \
	${datadir}/gdb/* \
	${datadir}/info/* \
	${datadir}/man/man1/${TARGET_PREFIX}* \
"

FILES_binutils-cross-canadian-${TRANSLATED_TARGET_ARCH} = "\
	${prefix}/${ELT_TARGET_SYS}/bin/ld* \
	${prefix}/${ELT_TARGET_SYS}/bin/objcopy \
	${prefix}/${ELT_TARGET_SYS}/bin/strip \
	${prefix}/${ELT_TARGET_SYS}/bin/nm \
	${prefix}/${ELT_TARGET_SYS}/bin/ranlib \
	${prefix}/${ELT_TARGET_SYS}/bin/as \
	${prefix}/${ELT_TARGET_SYS}/bin/ar \
	${prefix}/${ELT_TARGET_SYS}/bin/objdump \
	${prefix}/${ELT_TARGET_SYS}/lib/ldscripts/* \
	${bindir}/${TARGET_PREFIX}ld* \
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
"

DESCRIPTION_gcc-cross-canadian-${TRANSLATED_TARGET_ARCH} = "The GNU cc and gcc C compilers"
DESCRIPTION_gdb-cross-canadian-${TRANSLATED_TARGET_ARCH} = "gdb - GNU debugger"
DESCRIPTION_binutils-cross-canadian-${TRANSLATED_TARGET_ARCH} = "A GNU collection of binary utilities"

#LICENSE = "${ARG_LIC_LIBC}"
#LICENSE_gcc-cross-canadian-${TRANSLATED_TARGET_ARCH} = "${ARG_LIC_GCC}"
#LICENSE_gdb-cross-canadian-${TRANSLATED_TARGET_ARCH} = "${ARG_LIC_GDB}"
#LICENSE_binutils-cross-canadian-${TRANSLATED_TARGET_ARCH} = "${ARG_LIC_BFD}"

PKGV = "${ELT_VER_MAIN}"
PKGV_gcc-cross-canadian-${TRANSLATED_TARGET_ARCH} = "${ELT_VER_GCC}"
PKGV_gdb-cross-canadian-${TRANSLATED_TARGET_ARCH} = "${ELT_VER_GDB}"
PKGV_binutils-cross-canadian-${TRANSLATED_TARGET_ARCH} = "${ELT_VER_BFD}"

LIBDIR = "lib"
LIBDIR_aarch64 = "lib64"

do_install() {
	install -d ${D}${prefix}/${ELT_TARGET_SYS}/bin
	install -d ${D}${prefix}/${ELT_TARGET_SYS}/lib
	install -d ${D}${bindir}
	install -d ${D}${libdir}
	install -d ${D}${prefix}/${ELT_TARGET_SYS}/lib/ldscripts
	install -d ${D}${libexecdir}
	${@oe.utils.conditional('PREFERRED_PROVIDER_gdb-cross-canadian-${TRANSLATED_TARGET_ARCH}', 'external-linaro-sdk-toolchain', 'install -d ${D}${datadir}/gdb', '', d)}
	${@oe.utils.conditional('PREFERRED_PROVIDER_gdb-cross-canadian-${TRANSLATED_TARGET_ARCH}', 'external-linaro-sdk-toolchain', 'install -d ${D}${datadir}/info', '', d)}
	${@oe.utils.conditional('PREFERRED_PROVIDER_gdb-cross-canadian-${TRANSLATED_TARGET_ARCH}', 'external-linaro-sdk-toolchain', 'install -d ${D}${datadir}/man/man1', '', d)}
	install -d ${D}${gcclibdir}/${ELT_TARGET_SYS}/${ELT_VER_GCC}/include

	cp -a ${TOOLCHAIN_PATH}/${ELT_TARGET_SYS}/${LIBDIR}/{libstdc++.*,libgcc_s.*,libsupc++.*} ${D}${prefix}/${ELT_TARGET_SYS}/lib
	cp -a ${TOOLCHAIN_PATH}/lib/gcc/${ELT_TARGET_SYS}/${ELT_VER_GCC}/* ${D}${gcclibdir}/${ELT_TARGET_SYS}/${ELT_VER_GCC}
	cp -a ${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}{gcov,gcc*,g++,cpp} ${D}${bindir}
	cp -a ${TOOLCHAIN_PATH}/libexec/* ${D}${libexecdir}

	${@oe.utils.conditional('PREFERRED_PROVIDER_gdb-cross-canadian-${TRANSLATED_TARGET_ARCH}', 'external-linaro-sdk-toolchain', 'cp -a ${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}gdb* ${D}${bindir}', '', d)}
	${@oe.utils.conditional('PREFERRED_PROVIDER_gdb-cross-canadian-${TRANSLATED_TARGET_ARCH}', 'external-linaro-sdk-toolchain', 'cp -a ${TOOLCHAIN_PATH}/share/gdb/* ${D}${datadir}/gdb/', '', d)}
	${@oe.utils.conditional('PREFERRED_PROVIDER_gdb-cross-canadian-${TRANSLATED_TARGET_ARCH}', 'external-linaro-sdk-toolchain', 'cp -a ${TOOLCHAIN_PATH}/share/info/* ${D}${datadir}/info/', '', d)}
	${@oe.utils.conditional('PREFERRED_PROVIDER_gdb-cross-canadian-${TRANSLATED_TARGET_ARCH}', 'external-linaro-sdk-toolchain', 'cp -a ${TOOLCHAIN_PATH}/share/man/man1/${TARGET_PREFIX}* ${D}${datadir}/man/man1/', '', d)}

	cp -a ${TOOLCHAIN_PATH}/${ELT_TARGET_SYS}/bin/{ld*,objcopy,strip,nm,ranlib,as,ar,objdump} ${D}${prefix}/${ELT_TARGET_SYS}/bin
	cp -a ${TOOLCHAIN_PATH}/${ELT_TARGET_SYS}/lib/ldscripts/* ${D}${prefix}/${ELT_TARGET_SYS}/lib/ldscripts
	cp -a ${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}{ld*,addr2line,objcopy,readelf,strip,nm,ranlib,gprof,as,c++filt,ar,strings,objdump,size} ${D}${bindir}
}
