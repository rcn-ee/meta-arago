DESCRIPTION = "Wifi Direct Demo"
SECTION = "network"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://src/main.cpp;md5=cf285050f56a20d116b026c9f8ded4f7"

COMPATIBLE_MACHINE = "(am37x-evm|am335x-evm|am180x-evm|am181x-evm)"

PR = "r3"

BRANCH = "dbus"
SRCREV = "0950a67d9fe9a70668a993774e65ba9d457d750c"

SRC_URI = "git://git.profusion.mobi/users/lucas/wifi-direct-demo.git;protocol=git;branch=${BRANCH} \
           file://wifi-direct-demo.desktop"

require recipes-core/matrix/matrix-gui-paths.inc


S = "${WORKDIR}/git"

inherit qt4e

PLATFORM_am37x-evm = "omap3evm"
PLATFORM_omapl138 = "am1808"
PLATFORM_am335x-evm = "am335x"
PLATFORM ?= "UNKNOWN"

do_install () {
       install -d ${D}${bindir}
       install -m 755 ${S}/scripts/wifi_init.sh ${D}${bindir}/
       install -m 755 ${S}/scripts/wifi_exit.sh ${D}${bindir}/
       install -m 755 tmp/wifi-direct-demo ${D}/${bindir}/
       install -d 2755 ${D}${MATRIX_APP_DIR}/wifi-direct-demo
       install -m 644 ${S}/images/wifi-direct-icon.png ${D}${MATRIX_APP_DIR}/wifi-direct-demo
       install -m 644 ${WORKDIR}/wifi-direct-demo.desktop ${D}${MATRIX_APP_DIR}/wifi-direct-demo
}

PACKAGES += "matrix-gui-wifi-direct-demo"

FILES_${PN} +=" \
	${bindir}/wifi-direct-demo \
	${bindir}/wifi_init.sh \
	${bindir}/wifi_exit.sh \
	"

RDEPENDS_${PN} += "wpa-supplicant"

FILES_matrix-gui-wifi-direct-demo += " \
	${MATRIX_APP_DIR}/wifi-direct-demo/* \
	"

RDEPENDS_matrix-gui-wifi-direct-demo += "matrix-gui-apps-images matrix-gui-submenus-wifi ${PN}"
