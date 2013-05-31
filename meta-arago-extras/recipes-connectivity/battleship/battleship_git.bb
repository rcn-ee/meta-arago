DESCRIPTION = "Battleship game with wifi direct"
SECTION = "network"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=75859989545e37968a99b631ef42722e"

PR = "r8"

COMPATIBLE_MACHINE = "(omap3evm|am37x-evm|am335x-evm|am180x-evm|am181x-evm)"

BRANCH = "master"
SRCREV = "b5d47f31da94545f89b0333b879b533003f5c841"
PR_append = "+gitr${SRCPV}"

SRC_URI = "git://www.github.com/TI-ECS/battleship.git;protocol=git;branch=${BRANCH} \
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

PACKAGES += "matrix-gui-wifi-battleship-demo"

FILES_${PN} +=" \
	${bindir}/battleship \
	"

RDEPENDS_${PN} += "wpa-supplicant wifi-direct-launcher"

FILES_matrix-gui-wifi-battleship-demo += " \
	${MATRIX_APP_DIR}/battleship/* \
    "

RDEPENDS_matrix-gui-wifi-battleship-demo += "matrix-gui-apps-images matrix-gui-submenus-wifi ${PN}"
