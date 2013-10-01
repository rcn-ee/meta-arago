DESCRIPTION = "Simple Qt web display using webkit"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix_browser"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://main.cpp;beginline=9;endline=37;md5=884b90f5bf0d711fe32c4f04b5276496"
SECTION = "multimedia"

# Make sure that QT font libraries have been installed
RDEPENDS_${PN} += "qt4-embedded-fonts"

PR = "r2"

SRCREV = "db2e6b10e5a14358b6120a4a28de2f9d591bc55c"
BRANCH ?= "master"

SRC_URI = "git://gitorious.org/matrix-gui-v2/matrix_browser.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

inherit qt4e

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${B}/matrix_browser ${D}/${bindir}
}
