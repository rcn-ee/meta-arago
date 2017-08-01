PR_append = ".arago1"

PACKAGES =+ "${PN}-initramfs"

do_install_append() {
	[ ! -e ${D}/init ] && ln -s ${base_sbindir}/init ${D}/init
}

FILES_${PN}-initramfs = "/init"
RDEPENDS_${PN}-initramfs = "${PN}"
