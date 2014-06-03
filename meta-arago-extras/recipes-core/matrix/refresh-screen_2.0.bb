DESCRIPTION = "Simple Application to force a screen refresh"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/refresh-screen"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://main.cpp;beginline=9;endline=37;md5=884b90f5bf0d711fe32c4f04b5276496"
SECTION = "multimedia"

inherit qt-provider

# Make sure that QT font libraries have been installed
RDEPENDS_${PN} += "${QT_RDEPENDS_FONTS}"

PR = "r5"

SRCREV = "4dfdf85f17033f950e01f25341665f979edde6c3"
BRANCH ?= "master"

SRC_URI = "git://gitorious.org/matrix-gui-v2/refresh-screen.git;protocol=git;branch=${BRANCH}"

QT5_DIFF = " \
file://0001-refresh-screen.pro-add-widgets-module-to-the-project.patch \
file://0002-Replace-QtGui-header-with-QtWidgets-for-Qt5.patch \
"

SRC_URI += "${@base_conditional('QT_PROVIDER', 'qt5', "${QT5_DIFF}", '', d)}"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}/${bindir}
    install -m 0755 ${B}/refresh_screen ${D}/${bindir}
}
