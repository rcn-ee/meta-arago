ORIG_TARGET_SYS = "${TARGET_ARCH}${TARGET_VENDOR}${@['-' + d.getVar('TARGET_OS'), ''][d.getVar('TARGET_OS') == ('' or 'custom')]}"

do_install_append() {
	# libc.so linker script should use relative path to not clash with host libs
	sed -i -e "s# /lib# ../../lib#g" -e "s# /usr/lib# .#g" ${D}${libdir}/libc.so

	if [ ${EAT_TARGET_SYS} != ${ORIG_TARGET_SYS} ]; then
		ln -sf ${EAT_TARGET_SYS} ${D}${libdir}/${ORIG_TARGET_SYS}
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
