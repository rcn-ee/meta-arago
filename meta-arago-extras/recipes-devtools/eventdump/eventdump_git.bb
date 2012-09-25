DESCRIPTION = "Utility for parsing system events"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://eventdump.c;beginline=1;endline=34;md5=23b59be24a88ddc407b553035f3fd3e9"

PR = "r0+gitr${SRCREV}"

SRCREV = "5db45a36a05a78ea44a4cb25312ed5ee3c2bd76d"

SRC_URI = "git://github.com/TI-ECS/eventdump.git;protocol=git"

S = "${WORKDIR}/git"

do_install() {
	oe_runmake 'DEST_DIR=${D}' 'BIN_DIR=${bindir}' install
}
