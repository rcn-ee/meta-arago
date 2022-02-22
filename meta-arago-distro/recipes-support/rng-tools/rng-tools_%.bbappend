FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PR:append = ".arago0"

SRC_URI += "file://rngd.rules"

do_install:append() {
	# remove duplicate initscript
	rm -f ${D}${sysconfdir}/init.d/rng-tools

	install -d ${D}${sysconfdir}/udev/rules.d/
	install -m0644 ${WORKDIR}/rngd.rules ${D}${sysconfdir}/udev/rules.d/
}

INHIBIT_UPDATERCD_BBCLASS = "1"
