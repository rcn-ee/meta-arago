FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = ".arago2"

SRC_URI += "file://0001-HACK-TO-get-kexec-up-on-dra7.patch"

do_install_append() {
	chmod -x ${D}${sysconfdir}/init.d/kdump
}
