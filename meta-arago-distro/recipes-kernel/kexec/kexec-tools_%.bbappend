FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = ".arago2"

do_install_append() {
	chmod -x ${D}${sysconfdir}/init.d/kdump
}
