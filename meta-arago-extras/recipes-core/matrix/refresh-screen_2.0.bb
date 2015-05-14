DESCRIPTION = "Simple Application to force a screen refresh"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/refresh-screen"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://main.cpp;beginline=9;endline=37;md5=75a9adc782a6df0d3a5419743e9a9f18"
SECTION = "multimedia"

inherit qt-provider

# Make sure that QT font libraries have been installed
RDEPENDS_${PN} += "${QT_RDEPENDS_FONTS}"

PR = "r9"

SRCREV = "4c8817e28ceed2dd886761e3ec1971b11436ba33"
BRANCH ?= "master"

SRC_URI = "git://git.ti.com/matrix-gui-v2/refresh-screen.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}/${bindir}
    install -m 0755 ${B}/refresh_screen ${D}/${bindir}
}
