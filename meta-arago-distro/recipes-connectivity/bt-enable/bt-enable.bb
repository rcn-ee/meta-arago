SUMMARY = "Bluetooth enable script"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://bt-enable.sh;beginline=2;endline=18;md5=d134d0d385c53f9201a270fef8448f29"

SRC_URI = " \
	file://bt-enable.sh \
	file://bt-enable.service \
"

PR = "r1"

S = "${WORKDIR}"

INITSCRIPT_NAME = "bt-enable.sh"
INITSCRIPT_PARAMS = "defaults 99"

inherit allarch update-rc.d systemd

SYSTEMD_SERVICE_${PN} = "bt-enable.service"

do_install () {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 bt-enable.sh ${D}${sysconfdir}/init.d/

	install -d ${D}${systemd_system_unitdir}
	install -m0644 bt-enable.service ${D}${systemd_system_unitdir}
}
