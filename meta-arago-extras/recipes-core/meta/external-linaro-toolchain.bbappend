#INHIBIT_PACKAGE_STRIP = "0"

ALLOW_EMPTY_${PN}-utils = "1"
ALLOW_EMPTY_ldd = "1"

ALLOW_EMPTY_libstdc++ = "1"
ALLOW_EMPTY_libgomp = "1"

PR_append = ".arago33"

PROVIDES := "${@oe_filter_out('virtual/linux-libc-headers', '${PROVIDES}', d)}"
PROVIDES := "${@oe_filter_out('linux-libc-headers', '${PROVIDES}', d)}"

PROVIDES += "${@base_conditional('PREFERRED_PROVIDER_linux-libc-headers', 'external-linaro-toolchain', 'linux-libc-headers linux-libc-headers-dev', '', d)}"

RPROVIDES_${PN}-staticdev += "glibc-staticdev"

PACKAGES := "${@oe_filter_out('linux-libc-headers-dev', '${PACKAGES}', d)}"
PACKAGES := "${@oe_filter_out('linux-libc-headers', '${PACKAGES}', d)}"

PACKAGES += "${@base_conditional('PREFERRED_PROVIDER_linux-libc-headers', 'external-linaro-toolchain', 'linux-libc-headers-dev', '', d)}"

DEPENDS += "${@base_conditional('PREFERRED_PROVIDER_linux-libc-headers', 'external-linaro-toolchain', '', 'linux-libc-headers', d)}"

DEPENDS += "external-linaro-toolchain-cross-${TARGET_ARCH}"

RDEPENDS_${PN}-utils = ""

PKGV = "${ELT_VER_LIBC}"
PKGV_glibc-thread-db = "${ELT_VER_LIBC}"

FILES_${PN} = "${libc_baselibs} ${libexecdir}/* ${@base_conditional('USE_LDCONFIG', '1', '${base_sbindir}/ldconfig ${sysconfdir}/ld.so.conf', '', d)}"
FILES_${PN} += "\
	${libdir}/bin \
	${libdir}/locale \
	${libdir}/gconv/gconv-modules \
	${datadir}/zoneinfo \
	${base_libdir}/libcrypt*.so.* \
	${base_libdir}/libcrypt-*.so \
	${base_libdir}/libc.so.* \
	${libdir}/libc.so.* \
	${base_libdir}/libc-*.so \
	${base_libdir}/libm*.so.* \
	${base_libdir}/libm-*.so \
	${base_libdir}/ld*.so.* \
	${base_libdir}/ld-*.so \
	${base_libdir}/libpthread*.so.* \
	${base_libdir}/libpthread-*.so \
	${base_libdir}/libresolv*.so.* \
	${base_libdir}/libresolv-*.so \
	${base_libdir}/librt*.so.* \
	${base_libdir}/librt-*.so \
	${base_libdir}/libutil*.so.* \
	${base_libdir}/libutil-*.so \
	${base_libdir}/libnsl*.so.* \
	${base_libdir}/libnsl-*.so \
	${base_libdir}/libnss_files*.so.* \
	${base_libdir}/libnss_files-*.so \
	${base_libdir}/libnss_compat*.so.* \
	${base_libdir}/libnss_compat-*.so \
	${base_libdir}/libnss_dns*.so.* \
	${base_libdir}/libnss_dns-*.so \
	${base_libdir}/libnss_nis*.so.* \
	${base_libdir}/libnss_nisplus-*.so \
	${base_libdir}/libnss_nisplus*.so.* \
	${base_libdir}/libnss_nis-*.so \
	${base_libdir}/libnss_hesiod*.so.* \
	${base_libdir}/libnss_hesiod-*.so \
	${base_libdir}/libdl*.so.* \
	${base_libdir}/libdl-*.so \
	${base_libdir}/libanl*.so.* \
	${base_libdir}/libanl-*.so \
	${base_libdir}/libBrokenLocale*.so.* \
	${base_libdir}/libBrokenLocale-*.so \
	${base_libdir}/libcidn*.so.* \
	${base_libdir}/libcidn-*.so \
	${base_libdir}/libmemusage.so \
	${base_libdir}/libpcprofile.so \
"

FILES_linux-libc-headers = ""

FILES_linux-libc-headers-dev = "\
	${includedir}/asm* \
	${includedir}/linux \
	${includedir}/mtd \
	${includedir}/rdma \
	${includedir}/scsi \
	${includedir}/sound \
	${includedir}/video \
"

FILES_libgcc-dev += "\
	${libdir}/libgcc.a \
"

FILES_libstdc++-dev += "\
	/include/c++ \
"

FILES_libgomp-dev += "\
	${libdir}/gcc/${TARGET_SYS}/${ELT_VER_GCC}/include/omp.h \
	${libdir}/gcc/${ELT_TARGET_SYS} \
"

# Licenses set for main components of the toolchain:
# (g)libc is always LGPL version 2 (or later)
# gcc has switched from GPL version 2 (or later) to version 3 (or later) after 4.2.1,
#    see this announcement - http://gcc.gnu.org/ml/gcc-announce/2007/msg00003.html
# libgcc and libstdc++ always had exceptions to GPL called Runtime Library Exception, but
#    it was based on GPL version 2 (or later), until new GPL version 3 (or later) exception
#    was introduced on 27 Jan 2009 - http://gcc.gnu.org/ml/gcc-announce/2009/msg00000.html
#    and http://www.gnu.org/licenses/gcc-exception.html, which was several days after
#    gcc 4.3.3 was released - http://gcc.gnu.org/releases.html
# gdb/gdbserver version 6.6 was the last one under GPL version 2 (or later), according
#    to the release schedule - http://www.gnu.org/software/gdb/schedule/
# binutils version 2.17 was the last one under GPL version 2 (or later), according
#    to the published releases - http://ftp.gnu.org/gnu/binutils/
ELT_LIC_LIBC := "LGPL-2.1"
ELT_LIC_GCC := "${@["GPL-3", "GPL-2"][elt_get_gcc_version(d) <= "4.2.1"]}"
ELT_LIC_RLE := "${@["GPL-3-with-GCC-exception", "GPL-2-with-GCC-exception"][elt_get_gcc_version(d) <= "4.3.3"]}"
ELT_LIC_GDB := "${@["GPL-3", "GPL-2"][elt_get_gdb_version(d) <= "6.6"]}"
#ELT_LIC_BFD := "${@["GPL-3", "GPL-2"][elt_get_bfd_version(d) <= "2.17"]}"

LICENSE = "${ELT_LIC_LIBC}&${ELT_LIC_GCC}&${ELT_LIC_RLE}&${ELT_LIC_GDB}"
LICENSE_ldd = "${ELT_LIC_LIBC}"
LICENSE_glibc = "${ELT_LIC_LIBC}"
LICENSE_glibc-thread-db = "${ELT_LIC_LIBC}"
LICENSE_libgcc = "${ELT_LIC_RLE}"
LICENSE_libgcc-dev = "${ELT_LIC_RLE}"
LICENSE_libstdc++ = "${ELT_LIC_RLE}"
LICENSE_libstdc++-dev = "${ELT_LIC_RLE}"
LICENSE_libstdc++-staticdev = "${ELT_LIC_RLE}"
LICENSE_gdbserver = "${ELT_LIC_GDB}"
#LICENSE_binutils-dev = "${ELT_LIC_BFD}"

do_install_append() {
	sed -i -e "s# /lib/${ELT_TARGET_SYS}# ../../lib#g" -e "s# /usr/lib/${ELT_TARGET_SYS}# .#g" -e "s# /lib/ld-linux# ../../lib/ld-linux#g" ${D}${libdir}/libc.so
	sed -i -e "s# /lib/# ../../lib/#g" -e "s# /usr/lib/# ./#g" ${D}${libdir}/libc.so

	sed -i -e "s# /lib/${ELT_TARGET_SYS}# ../../lib#g" -e "s# /usr/lib/${ELT_TARGET_SYS}# .#g" ${D}${libdir}/libpthread.so
	sed -i -e "s# /lib/# ../../lib/#g" -e "s# /usr/lib/# ./#g" ${D}${libdir}/libpthread.so

	if [ -d ${TOOLCHAIN_PATH}/${ELT_TARGET_SYS}/libc/${bindir} ]; then
		cp -a ${TOOLCHAIN_PATH}/${ELT_TARGET_SYS}/libc/${bindir}/* ${D}${bindir}
	fi

	install -d ${D}${base_sbindir}
	cp -a ${TOOLCHAIN_PATH}/${ELT_TARGET_SYS}/libc/${base_sbindir}/ldconfig ${D}${base_sbindir}/
	install -d ${D}${sysconfdir}
	echo -e "/lib\n/usr/lib" >> ${D}${sysconfdir}/ld.so.conf

	install -d ${D}/include
	install -d ${D}${includedir}
	cp -a ${TOOLCHAIN_PATH}/${ELT_TARGET_SYS}/include/* ${D}${includedir}
	ln -sf ${ELT_TARGET_SYS} ${D}${includedir}/c++/${ELT_VER_GCC}/${TARGET_SYS}
	ln -sf ../usr/include/c++ ${D}/include/c++

	install -d ${D}${libdir}/gcc/${TARGET_SYS}/${ELT_VER_GCC}/include
	cp -a ${TOOLCHAIN_PATH}/${base_libdir}/gcc/${ELT_TARGET_SYS}/${ELT_VER_GCC}/include/omp.h ${D}${libdir}/gcc/${TARGET_SYS}/${ELT_VER_GCC}/include
	ln -sf ${TARGET_SYS} ${D}${libdir}/gcc/${ELT_TARGET_SYS}

	${@base_conditional('PREFERRED_PROVIDER_linux-libc-headers', 'external-linaro-toolchain', '', 'rm -rf ${D}${includedir}/asm*; rm -rf ${D}${includedir}/drm; rm -rf ${D}${includedir}/linux; rm -rf ${D}${includedir}/mtd; rm -rf ${D}${includedir}/rdma; rm -rf ${D}${includedir}/sound; rm -rf ${D}${includedir}/video', d)}
	${@base_conditional('PREFERRED_PROVIDER_linux-libc-headers', 'external-linaro-toolchain', '', 'rm -rf ${D}${includedir}/uapi/.install; rm -rf ${D}${includedir}/misc/.install; rm -rf ${D}${includedir}/misc/cxl.h; rm -rf ${D}${includedir}/scsi/.install; rm -rf ${D}${includedir}/scsi/scsi_netlink*; rm -rf ${D}${includedir}/scsi/scsi_bsg*; rm -rf ${D}${includedir}/scsi/cxlflash_ioctl.h; rm -rf ${D}${includedir}/scsi/fc; rm -rf ${D}${includedir}/xen', d)}

	rm ${D}${base_libdir}/*.spec
	rmdir ${D}${sbindir}
}
