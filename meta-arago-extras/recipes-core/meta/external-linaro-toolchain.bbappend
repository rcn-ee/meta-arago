ALLOW_EMPTY_${PN}-utils = "1"
ALLOW_EMPTY_ldd = "1"

ALLOW_EMPTY_libstdc++ = "1"
ALLOW_EMPTY_libgomp = "1"

PR_append = "-arago21"

PROVIDES := "${@oe_filter_out('virtual/linux-libc-headers', '${PROVIDES}', d)}"
PROVIDES := "${@oe_filter_out('linux-libc-headers', '${PROVIDES}', d)}"

PROVIDES += "${@base_conditional('PREFERRED_PROVIDER_linux-libc-headers', 'external-linaro-toolchain', 'linux-libc-headers linux-libc-headers-dev', '', d)}"

PACKAGES := "${@oe_filter_out('linux-libc-headers-dev', '${PACKAGES}', d)}"
PACKAGES := "${@oe_filter_out('linux-libc-headers', '${PACKAGES}', d)}"

PACKAGES += "${@base_conditional('PREFERRED_PROVIDER_linux-libc-headers', 'external-linaro-toolchain', 'linux-libc-headers-dev', '', d)}"

DEPENDS += "${@base_conditional('PREFERRED_PROVIDER_linux-libc-headers', 'external-linaro-toolchain', '', 'linux-libc-headers', d)}"

do_build[depends] += "external-linaro-toolchain-cross:do_populate_sysroot"

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

do_install_append() {
	mv ${D}${base_libdir}/libc.so ${D}${libdir}/libc.so || true
	mv ${D}${base_libdir}/libpthread.so ${D}${libdir}/libpthread.so || true

	install -d ${D}${base_sbindir}
	cp -a ${TOOLCHAIN_PATH}/${ELT_TARGET_SYS}/libc/${base_sbindir}/ldconfig ${D}${base_sbindir}/
	install -d ${D}${sysconfdir}
	echo -e "/lib\n/usr/lib" >> ${D}/${sysconfdir}/ld.so.conf
	( cd ${D}${libdir} && ln -sf ../../lib/libc.so.6 )

	${@base_conditional('PREFERRED_PROVIDER_linux-libc-headers', 'external-linaro-toolchain', '', 'rm -rf ${D}${includedir}/asm*; rm -rf ${D}${includedir}/drm; rm -rf ${D}${includedir}/linux; rm -rf ${D}${includedir}/mtd; rm -rf ${D}${includedir}/rdma; rm -rf ${D}${includedir}/sound; rm -rf ${D}${includedir}/video', d)}
	${@base_conditional('PREFERRED_PROVIDER_linux-libc-headers', 'external-linaro-toolchain', '', 'rm -rf ${D}${includedir}/uapi/.install; rm -rf ${D}${includedir}/misc/.install; rm -rf ${D}${includedir}/misc/cxl.h; rm -rf ${D}${includedir}/scsi/.install; rm -rf ${D}${includedir}/scsi/scsi_netlink*; rm -rf ${D}${includedir}/scsi/scsi_bsg*; rm -rf ${D}${includedir}/scsi/fc; rm -rf ${D}${includedir}/xen', d)}
}
