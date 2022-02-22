FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PR:append = ".arago2"

do_install:append() {
	chmod -x ${D}${sysconfdir}/init.d/kdump
}
