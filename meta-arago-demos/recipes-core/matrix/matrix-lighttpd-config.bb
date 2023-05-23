DESCRIPTION = "Lighttpd config for Matrix"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=e4dac5c6ab169aa212feb5028853a579"

inherit allarch

PR = "r2"

SRC_URI = "file://lighttpd.conf.matrix"

# Grabbed COPYING file from lighttpd_1.4.30
SRC_URI += "file://COPYING"

S = "${WORKDIR}"

do_install() {
	install -d ${D}${sysconfdir}/lighttpd
	install -m 0644 ${WORKDIR}/lighttpd.conf.matrix ${D}${sysconfdir}/lighttpd/lighttpd.conf.matrix
}

FILES:${PN} = "${sysconfdir}/lighttpd/lighttpd.conf.matrix"
RDEPENDS:${PN} = "lighttpd lighttpd-module-setenv"

pkg_postinst_ontarget:${PN} () {
if [ -f ${sysconfdir}/lighttpd/lighttpd.conf ] ; then
	cp ${sysconfdir}/lighttpd/lighttpd.conf.matrix ${sysconfdir}/lighttpd/lighttpd.conf
else
	echo "No lighttpd.conf found, aborting"
	exit 1
fi
}
