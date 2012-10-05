DESCRIPTION = "Bluetooth GUI Application"
SECTION = "network"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/main.cpp;beginline=1;endline=37;md5=83d75e9470fc1ba29e6f494fdef321be"
COMPATIBLE_MACHINE = "(omap3evm|am37x-evm|am335x-evm|am180x-evm|am181x-evm)"

BRANCH = "master"
SRCREV = "d9fc6f1ab023230170672d5243cbee58d740e7fe"

PR = "r12"

SRC_URI = "git://git.profusion.mobi/users/lucas/BT_Demo.git;protocol=git;branch=${BRANCH} \
           file://bluetooth-icon.png \
           file://desc_bluetooth.html \
           file://bt_demo.desktop"

require recipes-core/matrix/matrix-gui-paths.inc

S = "${WORKDIR}/git"

inherit qt4e

PLATFORM_am37x-evm = "omap3evm"
PLATFORM_omapl138 = "am1808"
PLATFORM_am335x-evm = "am335x"
PLATFORM ?= "UNKNOWN"

do_install () {
       install -d ${D}${bindir}
       install -m 755 BT_Demo ${D}/${bindir}/bluetooth-gui
       install -m 755 ${S}/scripts/BT_Init_${PLATFORM}.sh ${D}${bindir}/BT_Init.sh
       install -m 755 ${S}/scripts/BT_Exit.sh ${D}${bindir}
       install -d 2755 ${D}${MATRIX_APP_DIR}/bt_demo
       install -m 644 ${WORKDIR}/bt_demo.desktop ${D}${MATRIX_APP_DIR}/bt_demo
       install -m 644 ${WORKDIR}/desc_bluetooth.html ${D}${MATRIX_APP_DIR}/bt_demo
       install -m 644 ${WORKDIR}/bluetooth-icon.png ${D}${MATRIX_APP_DIR}/bt_demo
}

PACKAGES += "matrix-gui-bluetooth-demos"

FILES_${PN} +=" \
	${bindir}/bluetooth-gui \
	${bindir}/BT_Init.sh \
	${bindir}/BT_Exit.sh \
	"

RDEPENDS_${PN} += "pulseaudio"

FILES_matrix-gui-bluetooth-demos += " \
    	${MATRIX_APP_DIR}/bt_demo/* \
        "

RDEPENDS_matrix-gui-bluetooth-demos += "matrix-gui-apps-images matrix-gui-submenus-wifi ${PN}"

SRC_URI[md5sum] = "357da8591816ff05e81f31379bde9a01"
SRC_URI[sha256sum] = "aad229f585b21bf2eb4d3dee4b123271683b357bf0625b6da1ebced881595e6d"
