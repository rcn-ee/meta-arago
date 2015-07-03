# This recipe didn't exist in oe-core/meta-oe. Adding recipe here but the recipe 
# has been submitted to meta-oe.

DESCRIPTION = "A simple, small, portable, fast, and secure HTTP server."
LICENSE = "BSD"
HOMEPAGE = "http://www.acme.com/software/thttpd/"
PR ="r0"

LIC_FILES_CHKSUM = "file://thttpd.c;beginline=1;endline=26;md5=0c5762c2c34dcbe9eb18815516502872"
SRC_URI = "http://www.acme.com/software/thttpd/thttpd-${PV}.tar.gz \
	   file://install.patch \
	   file://acinclude.m4 \
	   file://init \
	   file://htpasswd_shared.diff \
       file://htpasswd_getline.diff"

S = "${WORKDIR}/thttpd-${PV}"

PARALLEL_MAKE = ""

INITSCRIPT_NAME = "thttpd"
INITSCRIPT_PARAMS = "defaults"

inherit autotools-brokensep update-rc.d

EXTRA_OEMAKE += "'WEBDIR=${servicedir}/www'"
FILES_${PN}-dbg_append = " ${servicedir}/www/cgi-bin/.debug"
FILES_${PN}_append = " ${servicedir}"

do_configure () {
	install -m 0644 ${WORKDIR}/acinclude.m4 ${S}/
	autotools_do_configure
}

do_install_append () {
	install -d "${D}${sysconfdir}/init.d"
	cat ${WORKDIR}/init | sed -e 's,@@SRVDIR,${servicedir}/www,g' > ${WORKDIR}/thttpd
	install -c -m 755 ${WORKDIR}/thttpd ${D}${sysconfdir}/init.d/thttpd
}


SRC_URI[md5sum] = "156b249b3b0bcd48b06badd2db0d56c5"
SRC_URI[sha256sum] = "07719b08b1cff6a21c08697a7bcb4395425b07ee753106262fb62a03a7d32360"
