DESCRIPTION = "Simple Application to force a screen refresh"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/refresh-screen"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://main.cpp;beginline=9;endline=37;md5=884b90f5bf0d711fe32c4f04b5276496"
SECTION = "multimedia"

# Make sure that QT font libraries have been installed
RDEPENDS_${PN} += "qt4-embedded-fonts"

PR = "r2"

SRCREV = "23acf023743e864bb30158636840a080e36d45b6"
BRANCH ?= "master"

SRC_URI = "git://gitorious.org/matrix-gui-v2/refresh-screen.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

inherit qt4e

do_install() {
    install -d ${D}/${bindir}
    install -m 0755 ${S}/refresh_screen ${D}/${bindir}
}
