ORIG_TARGET_SYS = "${TARGET_ARCH}${TARGET_VENDOR}${@['-' + d.getVar('TARGET_OS'), ''][d.getVar('TARGET_OS') == ('' or 'custom')]}"

do_install_append() {
	if [ ${EAT_TARGET_SYS} != ${ORIG_TARGET_SYS} ]; then
		ln -sf ${EAT_TARGET_SYS} ${D}${libdir}/${ORIG_TARGET_SYS}
		ln -sf ${EAT_TARGET_SYS} ${D}${includedir}/c++/${EAT_VER_GCC}/${ORIG_TARGET_SYS}
	fi

	ln -sf libatomic.so.1 ${D}${libdir}/libatomic.so
	ln -sf libgomp.so.1 ${D}${libdir}/libgomp.so
	ln -sf libitm.so.1 ${D}${libdir}/libitm.so
	ln -sf libssp.so.0 ${D}${libdir}/libssp.so
	ln -sf libstdc++.so.6 ${D}${libdir}/libstdc++.so
	ln -sf libubsan.so.1 ${D}${libdir}/libubsan.so
	ln -sf libasan.so.5 ${D}${libdir}/libasan.so
	ln -sf libgfortran.so.5 ${D}${libdir}/libgfortran.so
}
