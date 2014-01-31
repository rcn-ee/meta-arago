# This recipe installs an init script that can be used to invoke ts_calibrate
# on systems that need this done during the boot sequence.
DESCRIPTION = "TS calibration init script"
RDEPENDS_${PN} += "tslib"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://init;beginline=2;endline=11;md5=4b2e3b15f01cf63d2cb7988afdcc6c60"

PR = "r3"

S = "${WORKDIR}"

INITSCRIPT_NAME = "ts-calibrate"

# Start this init script early enough for other processes to be started later
# in the init sequence
INITSCRIPT_PARAMS = "start 96 2 3 4 5 ."

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit update-rc.d

SRC_URI = "file://init"

do_install(){
	# Install the init script
	# TODO: replace init script with systemd files
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/ts-calibrate
}
