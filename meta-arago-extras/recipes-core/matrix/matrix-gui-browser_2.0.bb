DESCRIPTION = "Simple Qt web display using webkit"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix_browser"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://main.cpp;beginline=9;endline=37;md5=75a9adc782a6df0d3a5419743e9a9f18"
SECTION = "multimedia"

inherit qt-provider

# Make sure that QT font libraries have been installed
RDEPENDS_${PN} += "${QT_RDEPENDS_FONTS}"

DEPENDS += "${QT_DEPENDS_WEBKIT}"

PR = "r12"

QT4_SRCREV = "83019b46fb3dec1a12667d251d35ba8682953a79"
QT5_SRCREV = "5ab1350db5892f1fec9995b53670f27977c69f8d"

SRCREV = "${@base_conditional('QT_PROVIDER', 'qt5', "${QT5_SRCREV}", "${QT4_SRCREV}", d)}"
BRANCH ?= "master"

SRC_URI = "git://git.ti.com/matrix-gui-v2/matrix_browser.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${B}/matrix_browser ${D}/${bindir}
}
