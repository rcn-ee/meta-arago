do_install_append() {
	# libc.so linker script should use relative path to not clash with host libs
	sed -i -e "s# /lib# ../../lib#g" -e "s# /usr/lib# .#g" ${D}${libdir}/libc.so
}
