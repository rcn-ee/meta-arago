DESCRIPTION = "Simple Qt web display using webkit"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix_browser"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://main.cpp;beginline=9;endline=37;md5=75a9adc782a6df0d3a5419743e9a9f18"
SECTION = "multimedia"

inherit qt-provider

# Make sure that QT font libraries have been installed
RDEPENDS_${PN} += "${QT_RDEPENDS_FONTS}"

DEPENDS += "${QT_DEPENDS_WEBKIT}"

PR = "r11"

SRCREV = "83019b46fb3dec1a12667d251d35ba8682953a79"
BRANCH ?= "master"

SRC_URI = "git://git.ti.com/matrix-gui-v2/matrix_browser.git;protocol=git;branch=${BRANCH}"

QT5_DIFF = " \
	file://qt5-webkit.patch \
	file://qt5-gui-widgets-move.patch \
	file://0001-Makefile.build-with-Qt5-use-qmake-available-in-PATH.patch \
"

SRC_URI += "${@base_conditional('QT_PROVIDER', 'qt5', "${QT5_DIFF}", '', d)}"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${B}/matrix_browser ${D}/${bindir}
}
