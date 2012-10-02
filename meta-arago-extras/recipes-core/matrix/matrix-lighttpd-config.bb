DESCRIPTION = "Lighttpd config for Matrix"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://../lighttpd.conf.matrix;md5=bf036dce30a4114d5942c1f8d0152191"

inherit allarch

PR = "1"

SRC_URI = "file://lighttpd.conf.matrix"

do_install() {
	install -d ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/lighttpd.conf.matrix ${D}${sysconfdir}/lighttpd.conf.matrix
}

FILES_${PN} = "${sysconfdir}/lighttpd.conf.matrix"
RDEPENDS_${PN} = "lighttpd"

pkg_postinst_${PN} () {
if [ -f $D${sysconfdir}/lighttpd.conf ] ; then
	cp $D${sysconfdir}/lighttpd.conf.matrix $D${sysconfdir}/lighttpd.conf
else
	echo "No lighttpd.conf found, aborting"
	exit 1
fi
}
