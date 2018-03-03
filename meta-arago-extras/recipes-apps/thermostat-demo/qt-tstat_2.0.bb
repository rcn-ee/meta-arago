DESCRIPTION = "Qt Thermostat Demo"
HOMEPAGE = "https://gitorious.org/thermostat-demo"

LICENSE = "BSD & CC-BY-SA-2.0 & CC-BY-SA-3.0 & MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=93a105adb99011afa5baee932b560714 \
                    file://IMAGE-LICENSE;md5=fce98146123de13a189c234a5e4cfa0d \
                    file://API-LICENSE;md5=5e32280d79a1eab76729c50d79ecfe72 \
                    file://remote/MIT-LICENSE.txt;md5=6a24093faaae5d5c198578c88e220071 \
"

require recipes-core/matrix/matrix-gui-paths.inc

inherit qt-provider

PR = "r10"

DEPENDS += "${QT_DEPENDS_SVG} ${QT_DEPENDS_SCRIPT}"

BRANCH ?= "master"
SRCREV = "665bff9a7bc0dbf82f9d6a58ff2778c03fe04fd1"

SRC_URI = "git://git.ti.com/apps/thermostat-demo.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git/"

DESKTOP_FILE = "${@oe.utils.conditional('QT_PROVIDER', 'qt5', 'thermostat_demo_qt5.desktop', 'thermostat_demo.desktop', d)}"


do_install() {
	install -d ${D}/usr/bin
	install -m 0755 ${B}/ThermostatDemo ${D}/usr/bin/ThermostatDemo
	install -d ${D}${MATRIX_APP_DIR}/qt_tstat
	install ${S}/matrix-files/desc_thermostat_demo.html  ${D}${MATRIX_APP_DIR}/qt_tstat
	install ${S}/matrix-files/${DESKTOP_FILE}  ${D}${MATRIX_APP_DIR}/qt_tstat/thermostat_demo.desktop
}

PACKAGES += "matrix-gui-thermostat-demo"

RDEPENDS_matrix-gui-thermostat-demo += "matrix-gui-apps-images ${@oe.utils.conditional('QT_PROVIDER', 'qt5', 'matrix-gui-submenus-qt5', 'matrix-gui-submenus-qt4', d)}"

FILES_matrix-gui-thermostat-demo += "${MATRIX_APP_DIR}/*"
