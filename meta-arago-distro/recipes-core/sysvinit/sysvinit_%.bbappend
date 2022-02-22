PR:append = ".arago1"

PACKAGES =+ "${PN}-initramfs"

do_install:append() {
	[ ! -e ${D}/init ] && ln -s ${base_sbindir}/init ${D}/init
}

FILES:${PN}-initramfs = "/init"
RDEPENDS:${PN}-initramfs = "${PN}"
