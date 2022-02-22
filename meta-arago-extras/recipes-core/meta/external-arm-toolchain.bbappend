ORIG_TARGET_SYS = "${TARGET_ARCH}${TARGET_VENDOR}${@['-' + d.getVar('TARGET_OS'), ''][d.getVar('TARGET_OS') == ('' or 'custom')]}"

do_install:append() {
	install -d ${D}${base_sbindir}
	cp -a ${TOOLCHAIN_PATH}/${EAT_TARGET_SYS}/libc/${base_sbindir}/ldconfig ${D}${base_sbindir}/
	install -d ${D}${sysconfdir}
	echo -e "/lib\n/usr/lib" >> ${D}${sysconfdir}/ld.so.conf

	if [ ${EAT_TARGET_SYS} != ${ORIG_TARGET_SYS} ]; then
		ln -sf ${EAT_TARGET_SYS} ${D}${libdir}/${ORIG_TARGET_SYS}
		ln -sf ${EAT_TARGET_SYS} ${D}${includedir}/c++/${EAT_VER_GCC}/${ORIG_TARGET_SYS}
		mv ${D}${libdir}/gcc/${EAT_TARGET_SYS} ${D}${libdir}/gcc/${ORIG_TARGET_SYS}
		ln -sf ${ORIG_TARGET_SYS} ${D}${libdir}/gcc/${EAT_TARGET_SYS}
	fi

	ln -sf libatomic.so.1 ${D}${libdir}/libatomic.so
	ln -sf libgomp.so.1 ${D}${libdir}/libgomp.so
	ln -sf libitm.so.1 ${D}${libdir}/libitm.so
	ln -sf libssp.so.0 ${D}${libdir}/libssp.so
	ln -sf libstdc++.so.6 ${D}${libdir}/libstdc++.so
	ln -sf libubsan.so.1 ${D}${libdir}/libubsan.so
	ln -sf libasan.so.5 ${D}${libdir}/libasan.so
	ln -sf libgfortran.so.5 ${D}${libdir}/libgfortran.so

	cp ${CP_ARGS} ${EXTERNAL_TOOLCHAIN}/lib/gcc/${EAT_TARGET_SYS}/${EAT_VER_GCC}/libgcc* ${D}${libdir}/${EAT_TARGET_SYS}/${EAT_VER_GCC}/
}

# Below FILES:* overrides are due to TARGET_SYS -> ORIG_TARGET_SYS move in ${libdir}/gcc
# to enable native compile on the target
FILES:libgcov-staticdev = "${libdir}/gcc/${ORIG_TARGET_SYS}/${BINV}/libgcov.a"

FILES:libgfortran-dev = "\
    ${libdir}/libgfortran*.so \
    ${libdir}/libgfortran.spec \
    ${libdir}/libgfortran.la \
    ${libdir}/gcc/${ORIG_TARGET_SYS}/${BINV}/libgfortranbegin.* \
    ${libdir}/gcc/${ORIG_TARGET_SYS}/${BINV}/libcaf_single* \
    ${libdir}/gcc/${ORIG_TARGET_SYS}/${BINV}/finclude/ \
"

FILES:gcc-sanitizers = "${libdir}/*.spec ${libdir}/gcc/${ORIG_TARGET_SYS}/${BINV}/include/sanitizer/*.h"

# This is provided by gcc:
#    ${libdir}/gcc/${ORIG_TARGET_SYS}/${BINV}/include
FILES:libgcc-dev = "\
    ${base_libdir}/libgcc*.so \
    ${@oe.utils.conditional('BASETARGET_SYS', '${ORIG_TARGET_SYS}', '', '${libdir}/${BASETARGET_SYS}', d)} \
    ${libdir}/${TARGET_SYS}/${BINV}* \
    ${libdir}/${TARGET_ARCH}${TARGET_VENDOR}* \
    ${libdir}/gcc/${TARGET_SYS} \
"

FILES:libssp-dev = "\
    ${libdir}/libssp*.so \
    ${libdir}/libssp*_nonshared.a \
    ${libdir}/libssp*.la \
    ${libdir}/gcc/${ORIG_TARGET_SYS}/${BINV}/include/ssp \
"

FILES:libquadmath-dev = "\
    ${libdir}/libquadmath*.so \
    ${libdir}/libquadmath.la \
    ${libdir}/gcc/${ORIG_TARGET_SYS}/${BINV}/include/quadmath* \
"

FILES:libgomp-dev = "\
    ${libdir}/libgomp*${SOLIBSDEV} \
    ${libdir}/libgomp*.la \
    ${libdir}/libgomp.spec \
    ${libdir}/gcc/${ORIG_TARGET_SYS}/${BINV}/include/omp.h \
"

INSANE_SKIP:libgcc-dev += "staticdev"
