DESCRIPTION = "Simple Qt web display using webengine"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://main.cpp;beginline=9;endline=37;md5=75a9adc782a6df0d3a5419743e9a9f18"
SECTION = "multimedia"

inherit qt5

DEPENDS += "qtwebkit"

PR = "r17"

SRCREV = "78ad5db716d1abc4c05abfe435f066b6b88454d5"

BRANCH ?= "master"

SRC_URI = "git://git.ti.com/matrix-gui-v2/matrix_browser.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${B}/matrix_browser ${D}/${bindir}
}
