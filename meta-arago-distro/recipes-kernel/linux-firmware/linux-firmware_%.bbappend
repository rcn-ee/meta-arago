PR_append = ".arago0"

do_install_append() {
	rm -rf  ${D}/lib/firmware/ti-connectivity/
}
