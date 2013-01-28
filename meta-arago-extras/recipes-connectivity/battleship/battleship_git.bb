DESCRIPTION = "Battleship game with wifi direct"
SECTION = "network"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=75859989545e37968a99b631ef42722e"

PR = "r5"

COMPATIBLE_MACHINE = "(omap3evm|am37x-evm|am335x-evm|am180x-evm|am181x-evm)"

BRANCH = "master"
SRCREV = "78524080276f5395b91c1d36858522f69f529462"
PR_append = "+gitr${SRCREV}"

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

RDEPENDS_${PN} += "wpa-supplicant"

FILES_matrix-gui-wifi-battleship-demo += " \
	${MATRIX_APP_DIR}/battleship/* \
    "

RDEPENDS_matrix-gui-wifi-battleship-demo += "matrix-gui-apps-images matrix-gui-submenus-wifi ${PN}"
