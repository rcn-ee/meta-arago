INSANE_SKIP_libstdc++-dev += "staticdev"

ALLOW_EMPTY_${PN}-utils = "1"

PR_append = "-arago4"

PROVIDES := "${@oe_filter_out('virtual/linux-libc-headers', '${PROVIDES}', d)}"
PROVIDES := "${@oe_filter_out('linux-libc-headers', '${PROVIDES}', d)}"
PROVIDES += "virtual/${TARGET_PREFIX}gcc-intermediate"
PROVIDES += "${@base_conditional('PREFERRED_PROVIDER_linux-libc-headers', 'external-linaro-toolchain', 'linux-libc-headers linux-libc-headers-dev', '', d)}"

PACKAGES := "${@oe_filter_out('linux-libc-headers-dev', '${PACKAGES}', d)}"
PACKAGES := "${@oe_filter_out('linux-libc-headers', '${PACKAGES}', d)}"
PACKAGES := "${@oe_filter_out('libsegfault', '${PACKAGES}', d)}"
PACKAGES =+ "libsegfault"
PACKAGES += "${@base_conditional('PREFERRED_PROVIDER_linux-libc-headers', 'external-linaro-toolchain', 'linux-libc-headers-dev', '', d)}"

DEPENDS += "${@base_conditional('PREFERRED_PROVIDER_linux-libc-headers', 'external-linaro-toolchain', '', 'linux-libc-headers', d)}"

RDEPENDS_${PN}-utils = ""

PKGV = "${ELT_VER_LIBC}"
PKGV_eglibc-thread-db = "${ELT_VER_LIBC}"

FILES_${PN} = "${libc_baselibs} ${libexecdir}/* ${@base_conditional('USE_LDCONFIG', '1', '${base_sbindir}/ldconfig ${sysconfdir}/ld.so.conf', '', d)}"
FILES_${PN} += "\
	${libdir}/bin \
	${libdir}/locale \
	${libdir}/gconv/gconv-modules \
	${datadir}/zoneinfo \
	${base_libdir}/libcrypt*.so.* \
	${base_libdir}/libcrypt-*.so \
	${base_libdir}/libc.so.* \
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

FILES_${PN}-dev += "\
	${libdir}/*.a \
	${base_libdir}/*.a \
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

FILES_libstdc++-dev = "\
	/include/c++ \
	${base_libdir}/libstdc++.so \
	${base_libdir}/libstdc++.a \
	${base_libdir}/libsupc++.a \
"

do_install_append() {
	install -d ${D}/include
	cp -a ${TOOLCHAIN_PATH}/${ELT_TARGET_SYS}/include/* ${D}/include

	${@base_conditional('PREFERRED_PROVIDER_linux-libc-headers', 'external-linaro-toolchain', '', 'rm -rf ${D}${includedir}/asm*; rm -rf ${D}${includedir}/drm; rm -rf ${D}${includedir}/linux; rm -rf ${D}${includedir}/mtd; rm -rf ${D}${includedir}/rdma; rm -rf ${D}${includedir}/sound; rm -rf ${D}${includedir}/video', d)}
	${@base_conditional('PREFERRED_PROVIDER_linux-libc-headers', 'external-linaro-toolchain', '', 'rm -rf ${D}${includedir}/scsi/.install; rm -rf ${D}${includedir}/scsi/scsi_netlink*; rm -rf ${D}${includedir}/scsi/scsi_bsg*', d)}

	rm -rf ${D}/lib/libgfortran*
	rm -rf ${D}/lib/ldscripts
	rm -rf ${D}${datadir}/lintian
	rm -r ${D}${bindir} || true
	rm -r ${D}${sbindir} || true
	rm -r ${D}${libexecdir} || true
}
