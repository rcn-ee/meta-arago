DESCRIPTION = "Simple Application to force a screen refresh"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/refresh-screen"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://main.cpp;beginline=9;endline=37;md5=884b90f5bf0d711fe32c4f04b5276496"
SECTION = "multimedia"

# Make sure that QT font libraries have been installed
RDEPENDS_${PN} += "qt4-embedded-fonts"

PR = "r4"

SRCREV = "4dfdf85f17033f950e01f25341665f979edde6c3"
BRANCH ?= "master"

SRC_URI = "git://gitorious.org/matrix-gui-v2/refresh-screen.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

inherit qt4e

do_install() {
    install -d ${D}/${bindir}
    install -m 0755 ${S}/refresh_screen ${D}/${bindir}
}
