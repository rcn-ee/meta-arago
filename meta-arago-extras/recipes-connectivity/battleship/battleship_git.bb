DESCRIPTION = "Battleship game with wifi direct"
SECTION = "network"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/kgamecanvas.cpp;beginline=1;endline=25;md5=b4fc9c236e9a19cfaeaca80abbb29032"

PR = "r2"

COMPATIBLE_MACHINE = "(omap3evm|am37x-evm|am335x-evm|am180x-evm|am181x-evm)"

BRANCH = "dbus"
SRCREV = "644e7d37e982e3f8f3b93b01e115b11a6da161bb"
PR_append = "+gitr${SRCREV}"

SRC_URI = "git://git.profusion.mobi/users/lucas/battleship.git;protocol=git;branch=${BRANCH} \
           file://battleship.desktop"

require recipes-core/matrix/matrix-gui-paths.inc

S = "${WORKDIR}/git"

inherit qt4e

PLATFORM_am37x-evm = "omap3evm"
PLATFORM_omapl138 = "am1808"
PLATFORM_am335x-evm = "am335x"
PLATFORM ?= "UNKNOWN"

do_install () {
       install -d ${D}${bindir}
       install -m 755 tmp/battleship ${D}/${bindir}/battleship
       install -d 2755 ${D}${MATRIX_APP_DIR}/battleship
       install -m 644 ${S}/data/battleship-icon.png ${D}${MATRIX_APP_DIR}/battleship
       install -m 644 ${WORKDIR}/battleship.desktop ${D}${MATRIX_APP_DIR}/battleship
}

PACKAGES += "${PN} matrix-gui-wifi-battleship-demo"

FILES_${PN} +=" \
	${bindir}/battleship \
	"

RDEPENDS_${PN} += "wpa-supplicant"

FILES_matrix-gui-wifi-battleship-demo += " \
	${MATRIX_APP_DIR}/battleship/* \
    "

RDEPENDS_matrix-gui-wifi-battleship-demo += "matrix-gui-apps-images matrix-gui-submenus-wifi ${PN}"
