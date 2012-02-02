DESCRIPTION = "Initscripts for telnetd"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://telnetd;beginline=2;endline=18;md5=d134d0d385c53f9201a270fef8448f29"
PR ="r0"

SRC_URI = "file://telnetd"

S = "${WORKDIR}"

INITSCRIPT_NAME = "telnetd"
INITSCRIPT_PARAMS = "defaults 10"

inherit update-rc.d

do_install () {
	install -d ${D}${sysconfdir}/init.d/
	install -c -m 755 ${S}/telnetd ${D}${sysconfdir}/init.d/telnetd
}
