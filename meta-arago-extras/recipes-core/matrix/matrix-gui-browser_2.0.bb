DESCRIPTION = "Simple Qt web display using webkit"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix_browser"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://main.cpp;beginline=9;endline=37;md5=884b90f5bf0d711fe32c4f04b5276496"
SECTION = "multimedia"

inherit qt-provider

# Make sure that QT font libraries have been installed
RDEPENDS_${PN} += "${QT_RDEPENDS_FONTS}"

DEPENDS += "${QT_DEPENDS_WEBKIT}"

PR = "r9"

SRCREV = "7f5dccfb5b1b68a3f9162f6ee072eef0e0ba06fe"
BRANCH ?= "master"

SRC_URI = "git://gitorious.org/matrix-gui-v2/matrix_browser.git;protocol=http;branch=${BRANCH}"

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
