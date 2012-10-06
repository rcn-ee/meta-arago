DESCRIPTION = "Lighttpd config for Matrix"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=e4dac5c6ab169aa212feb5028853a579"

inherit allarch

PR = "r2"

SRC_URI = "file://lighttpd.conf.matrix"

# Grabbed COPYING file from lighttpd_1.4.30
SRC_URI += "file://COPYING"

S = "${WORKDIR}"

do_install() {
	install -d ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/lighttpd.conf.matrix ${D}${sysconfdir}/lighttpd.conf.matrix
}

FILES_${PN} = "${sysconfdir}/lighttpd.conf.matrix"
RDEPENDS_${PN} = "lighttpd lighttpd-module-setenv"

pkg_postinst_${PN} () {
if [ -f $D${sysconfdir}/lighttpd.conf ] ; then
	cp $D${sysconfdir}/lighttpd.conf.matrix $D${sysconfdir}/lighttpd.conf
else
	echo "No lighttpd.conf found, aborting"
	exit 1
fi
}
