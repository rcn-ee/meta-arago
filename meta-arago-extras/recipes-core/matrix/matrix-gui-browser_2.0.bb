DESCRIPTION = "Simple Qt web display using webengine"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix_browser"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://main.cpp;beginline=9;endline=37;md5=75a9adc782a6df0d3a5419743e9a9f18"
SECTION = "multimedia"

inherit qt-provider

# Make sure that QT font libraries have been installed
RDEPENDS_${PN} += "${QT_RDEPENDS_FONTS}"

DEPENDS += "${QT_DEPENDS_WEBENGINE}"
#DEPENDS_k3 += "${QT_DEPENDS_WEBKIT}"
#DEPENDS_remove_k3 = "${QT_DEPENDS_WEBENGINE}"

PR = "r16"

QT4_SRCREV = "83019b46fb3dec1a12667d251d35ba8682953a79"
QT5_SRCREV = "d3ecf8d0dff3e4f901d588ea0dfe485733dfc9dc"
#QT5_SRCREV_k3 = "78ad5db716d1abc4c05abfe435f066b6b88454d5"


SRCREV = "${@oe.utils.conditional('QT_PROVIDER', 'qt5', "${QT5_SRCREV}", "${QT4_SRCREV}", d)}"
BRANCH ?= "master"

SRC_URI = "git://git.ti.com/matrix-gui-v2/matrix_browser.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${B}/matrix_browser ${D}/${bindir}
}
