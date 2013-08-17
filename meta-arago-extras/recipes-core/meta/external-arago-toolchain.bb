require recipes-core/eglibc/eglibc-package.inc

require external-arago-toolchain.inc

PR = "r4"

INHIBIT_DEFAULT_DEPS = "1"

# License applies to this recipe code, not the toolchain itself
LICENSE = "MIT"
LIC_FILES_CHKSUM = "\
	file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
	file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420 \
"

PACKAGE_NO_GCONV = "1"
PACKAGE_NO_LOCALE = "1"

ALLOW_EMPTY_libgcc = "1"
ALLOW_EMPTY_libstdc++ = "1"

INSANE_SKIP_libgcc = "True"
INSANE_SKIP_libstdc++ = "True"
INSANE_SKIP_glibc-utils = "True"
INSANE_SKIP_glibc-dev = "True"
INSANE_SKIP_gdbserver = "True"

SRC_URI = "file://SUPPORTED"

PROVIDES = "\
	virtual/${TARGET_PREFIX}gcc \
	virtual/${TARGET_PREFIX}g++ \
	virtual/${TARGET_PREFIX}gcc-initial \
	virtual/${TARGET_PREFIX}gcc-intermediate \
	virtual/${TARGET_PREFIX}binutils \
	virtual/${TARGET_PREFIX}libc-for-gcc \
	virtual/${TARGET_PREFIX}compilerlibs \
	virtual/libc \
	virtual/libintl \
	virtual/libiconv \
	glibc-thread-db \
	libgcc \
	${@base_conditional('PREFERRED_PROVIDER_linux-libc-headers', 'external-arago-toolchain', 'linux-libc-headers linux-libc-headers-dev', '', d)} \
	${@base_conditional('PREFERRED_PROVIDER_gdbserver', 'external-arago-toolchain', 'gdbserver', '', d)} \
	${@base_conditional('PREFERRED_PROVIDER_binutils-dev', 'external-arago-toolchain', 'binutils-dev', '', d)} \
"

DEPENDS = "${@base_conditional('PREFERRED_PROVIDER_linux-libc-headers', 'external-arago-toolchain', '', 'linux-libc-headers', d)}"
RPROVIDES_glibc-dev += "libc-dev libc6-dev virtual-libc-dev"
PACKAGES_DYNAMIC += "glibc-gconv-*"
PACKAGES_DYNAMIC += "glibc-locale-*"

LEAD_SONAME = "libc.so.6"

PACKAGES = "\
	libgcc \
	libgcc-dev \
	libstdc++ \
	libstdc++-dev \
	${@base_conditional('PREFERRED_PROVIDER_linux-libc-headers', 'external-arago-toolchain', 'linux-libc-headers-dev', '', d)} \
	${@base_conditional('PREFERRED_PROVIDER_gdbserver', 'external-arago-toolchain', 'gdbserver', '', d)} \
	${@base_conditional('PREFERRED_PROVIDER_binutils-dev', 'external-arago-toolchain', 'binutils-dev', '', d)} \
	glibc-dbg \
	glibc \
	catchsegv \
	sln \
	nscd \
	ldd \
	localedef \
	glibc-utils \
	glibc-dev \
	glibc-locale \
	libsegfault \
	glibc-extra-nss \
	glibc-thread-db \
	glibc-pcprofile \
"

FILES_glibc = "\
	${sysconfdir} \
	${libexecdir}/* \
	${datadir}/zoneinfo \
	/lib/libc* \
	/lib/libm* \
	/lib/ld* \
	/lib/libpthread* \
	/lib/libresolv* \
	/lib/librt* \
	/lib/libutil* \
	/lib/libnsl* \
	/lib/libnss_files* \
	/lib/libnss_compat* \
	/lib/libnss_dns* \
	/lib/libdl* \
	/lib/libanl* \
	/lib/libBrokenLocale* \
	/sbin/ldconfig \
"

FILES_glibc-dev = "\
	${includedir} \
	${libdir}/*.o \
	${bindir}/rpcgen \
	${libdir}/*.so \
	${libdir}/*.a \
"

FILES_glibc-dbg += " ${libdir}/gconv/.debug ${libexecdir}/*/.debug ${base_libdir}/.debug ${libdir}/.debug"
FILES_glibc-utils = "${bindir}/* ${sbindir}/*"
FILES_glibc-extra-nss = "/lib/libnss*"
FILES_glibc-gconv = "${libdir}/gconv/*"
FILES_glibc-pcprofile = "/lib/libpcprofile.so"
FILES_glibc-thread-db = "/lib/libthread_db*"

FILES_libgcc = "${base_libdir}/libgcc_s.so.1"
FILES_libgcc-dev = "${base_libdir}/libgcc_s.so"

FILES_libstdc++ = "${libdir}/libstdc++.so.*"
FILES_libstdc++-dev = "\
	/include/c++ \
	${libdir}/libstdc++.so \
	${libdir}/libstdc++.la \
	${libdir}/libstdc++.a \
	${libdir}/libsupc++.la \
	${libdir}/libsupc++.a \
"

FILES_binutils-dev = "\
	${includedir}/ansidecl.h \
	${includedir}/dis-asm.h \
	${includedir}/bfdlink.h \
	${includedir}/libiberty.h \
	${includedir}/symcat.h \
	${includedir}/bfd.h \
	${libdir}/libbfd* \
	${libdir}/libopcodes* \
	${libdir}/libiberty* \
"

FILES_linux-libc-headers-dev = "\
	${includedir}/asm* \
	${includedir}/drm \
	${includedir}/linux \
	${includedir}/mtd \
	${includedir}/rdma \
	${includedir}/scsi \
	${includedir}/sound \
	${includedir}/video \
"

FILES_libsegfault = "/lib/libSegFault*"
FILES_catchsegv = "${bindir}/catchsegv"
RDEPENDS_catchsegv = "libsegfault"

FILES_ldd = "${bindir}/ldd"
FILES_nscd = "${sbindir}/nscd*"
FILES_sln = "${base_sbindir}/sln"
FILES_localedef = "${bindir}/localedef"
FILES_gdbserver = "${bindir}/gdbserver"

DESCRIPTION_glibc-utils = "glibc: misc utilities like iconf, local, gencat, tzselect, rpcinfo, ..."
DESCRIPTION_glibc-extra-nss = "glibc: nis, nisplus and hesiod search services"
DESCRIPTION_ldd = "glibc: print shared library dependencies"
DESCRIPTION_nscd = "glibc: name service cache daemon for passwd, group, and hosts"
DESCRIPTION_sln = "glibc: create symbolic links between files"
DESCRIPTION_localedef = "glibc: compile locale definition files"
DESCRIPTION_gdbserver = "gdb: GNU debugger"
DESCRIPTION_binutils-dev = "binutils: GNU collection of binary utilities"

LICENSE = "${ARG_LIC_LIBC}"
LICENSE_ldd = "${ARG_LIC_LIBC}"
LICENSE_glibc = "${ARG_LIC_LIBC}"
LICENSE_glibc-thread-db = "${ARG_LIC_LIBC}"
LICENSE_libgcc = "${ARG_LIC_RLE}"
LICENSE_libgcc-dev = "${ARG_LIC_RLE}"
LICENSE_libstdc++ = "${ARG_LIC_RLE}"
LICENSE_libstdc++-dev = "${ARG_LIC_RLE}"
LICENSE_gdbserver = "${ARG_LIC_GDB}"
LICENSE_binutils-dev = "${ARG_LIC_BFD}"

PKG_${PN} = "eglibc"
PKG_${PN}-dev = "eglibc-dev"
PKG_${PN}-doc = "eglibc-doc"
PKG_${PN}-dbg = "eglibc-dbg"
PKG_${PN}-pic = "eglibc-pic"
PKG_${PN}-utils = "eglibc-utils"
PKG_${PN}-gconv = "eglibc-gconv"
PKG_${PN}-extra-nss = "eglibc-extra-nss"
PKG_${PN}-thread-db = "eglibc-thread-db"
PKG_${PN}-pcprofile = "eglibc-pcprofile"

PKGV = "${ARG_VER_LIBC}"
#PKGV = "${ARG_VER_MAIN}"
PKGV_libgcc = "${ARG_VER_GCC}"
PKGV_libgcc-dev = "${ARG_VER_GCC}"
PKGV_libstdc++ = "${ARG_VER_GCC}"
PKGV_libstdc++-dev = "${ARG_VER_GCC}"
PKGV_libc = "${ARG_VER_LIBC}"
PKGV_glibc = "${ARG_VER_LIBC}"
PKGV_glibc-dev = "${ARG_VER_LIBC}"
PKGV_glibc-dbg = "${ARG_VER_LIBC}"
PKGV_glibc-utils = "${ARG_VER_LIBC}"
PKGV_glibc-gconv = "${ARG_VER_LIBC}"
PKGV_glibc-extra-nss = "${ARG_VER_LIBC}"
PKGV_glibc-thread-db = "${ARG_VER_LIBC}"
PKGV_glibc-pcprofile = "${ARG_VER_LIBC}"
PKGV_catchsegv = "${ARG_VER_LIBC}"
PKGV_sln = "${ARG_VER_LIBC}"
PKGV_nscd = "${ARG_VER_LIBC}"
PKGV_ldd = "${ARG_VER_LIBC}"
PKGV_localedef = "${ARG_VER_LIBC}"
PKGV_libsegfault = "${ARG_VER_LIBC}"
PKGV_linux-libc-headers-dev = "${ARG_VER_KERNEL}"
PKGV_gdbserver = "${ARG_VER_GDB}"
PKGV_binutils-dev = "${ARG_VER_BFD}"

do_int_binutils() {
	cp -a ${TOOLCHAIN_PATH}/${ARAGO_TARGET_SYS}${libdir}/{libbfd*,libopcodes*,libiberty*} ${D}${libdir}
}

do_ext_binutils() {
	rm -rf ${D}${includedir}/{ansidecl.h,dis-asm.h,bfdlink.h,libiberty.h,symcat.h,bfd.h}
}

do_install() {
	install -d ${D}${sysconfdir}
	install -d ${D}${bindir}
	install -d ${D}${sbindir}
	install -d ${D}${base_bindir}
	install -d ${D}${libdir}
	install -d ${D}${base_libdir}
	install -d ${D}${base_sbindir}
	install -d ${D}${datadir}
	install -d ${D}${includedir}
	install -d ${D}/include

	cp -a ${TOOLCHAIN_PATH}/${ARAGO_TARGET_SYS}${datadir}/* ${D}${datadir}
	cp -a ${TOOLCHAIN_PATH}/${ARAGO_TARGET_SYS}${base_libdir}/{lib*,ld*} ${D}${base_libdir}
	cp -a ${TOOLCHAIN_PATH}/${ARAGO_TARGET_SYS}${base_sbindir}/ldconfig ${D}${base_sbindir}
	cp -a ${TOOLCHAIN_PATH}/${ARAGO_TARGET_SYS}${bindir}/{gdbserver,gencat,getconf,getent,iconv,locale,mtrace,pcprofiledump,rpcgen,sprof,tzselect,xtrace} ${D}${bindir}
	cp -a ${TOOLCHAIN_PATH}/${ARAGO_TARGET_SYS}${sbindir}/{iconvconfig,rpcinfo,zdump,zic} ${D}${sbindir}
	cp -a ${TOOLCHAIN_PATH}/${ARAGO_TARGET_SYS}${includedir}/{arpa,asm*,bits,drm,gnu,linux,mtd,net*,nfs,protocols,rdma,rpc*,scsi,sound,sys*,video,*.h} ${D}${includedir}
	cp -a ${TOOLCHAIN_PATH}/${ARAGO_TARGET_SYS}${libdir}/{?crt1.o,crt?.o,libBrokenLocale*,libanl*,libc.*,libc_*,libcrypt.*,libcidn.*,libdl.*,libg.*,libieee.*,libm.*,libmcheck.*,libnsl*,libnss*,libpthread*,libresolv*,librt*,libstdc*,libsupc*,libthread*,libutil*} ${D}${libdir}
	rm -rf ${D}${base_libdir}/*.la
	rm -rf ${D}${libdir}/*.la
	rm -rf ${D}${includedir}/{zconf,zlib}.h

	${@base_conditional('PREFERRED_PROVIDER_linux-libc-headers', 'external-arago-toolchain', '', 'rm -rf ${D}${includedir}/asm*; rm -rf ${D}${includedir}/drm; rm -rf ${D}${includedir}/linux; rm -rf ${D}${includedir}/mtd; rm -rf ${D}${includedir}/rdma; rm -rf ${D}${includedir}/sound; rm -rf ${D}${includedir}/video', d)}
	${@base_conditional('PREFERRED_PROVIDER_linux-libc-headers', 'external-arago-toolchain', '', 'rm -rf ${D}${includedir}/scsi/.install; rm -rf ${D}${includedir}/scsi/scsi_netlink*; rm -rf ${D}${includedir}/scsi/scsi_bsg*', d)}

	cp -a ${TOOLCHAIN_PATH}/${ARAGO_TARGET_SYS}/include/* ${D}/include
	${@base_conditional('PREFERRED_PROVIDER_gdbserver', 'external-arago-toolchain', '', 'rm -rf ${D}${bindir}/gdbserver', d)}

	${@base_conditional('PREFERRED_PROVIDER_binutils-dev', 'external-arago-toolchain', 'do_int_binutils', 'do_ext_binutils', d)}

	sed -e "s# /lib# ../../lib#g" -e "s# /usr/lib# .#g" ${D}${libdir}/libc.so > ${D}${libdir}/temp
	mv ${D}${libdir}/temp ${D}${libdir}/libc.so

	sed -e "s# /lib# ../../lib#" -e "s# /usr/lib# .#g" ${D}${libdir}/libpthread.so > ${D}${libdir}/temp
	mv ${D}${libdir}/temp ${D}${libdir}/libpthread.so
}
