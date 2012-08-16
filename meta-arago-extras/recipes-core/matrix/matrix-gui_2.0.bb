DESCRIPTION = "Matrix GUI Application launcher"
HOMEPAGE = "https://gforge.ti.com/gf/project/matrix-gui-v2/"

LICENSE = "BSD MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a886c9ef769b2d8271115d2502512e5d"

SECTION = "multimedia"

PR = "r9"

INITSCRIPT_NAME = "matrix-gui-2.0"
INITSCRIPT_PARAMS = "defaults 97"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit update-rc.d

BRANCH ?= "master"
SRCREV = "57574e157aee2d4781e6aa04199c7e3bca9ad62c"

SRC_URI = "git://gitorious.org/matrix-gui-v2/matrix-gui-v2.git;protocol=git;branch=${BRANCH} \
           file://init \
           file://php.ini"

require matrix-gui-paths.inc

S = "${WORKDIR}/git"

MATRIX_ROT = ""
MATRIX_ROT_am37x-evm = "-display transformed:Rot90"

do_install(){
	install -d ${D}${MATRIX_BASE_DIR}
	install -d ${D}${MATRIX_WEB_DIR}
	cp -rf ${S}/* ${D}${MATRIX_WEB_DIR}

	# Install our php.ini file
	install -m 0644 ${WORKDIR}/php.ini ${D}${MATRIX_BASE_DIR}/

	# Set the proper path in the init script
	sed -i -e s=__MATRIX_WEB_DIR__=${MATRIX_WEB_DIR}= ${WORKDIR}/init
	sed -i -e "s/__MATRIX_ROT__/\"${MATRIX_ROT}\"/" ${WORKDIR}/init

	# Install the init script
	# TODO: replace init script with systemd files
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/matrix-gui-2.0
}

RDEPENDS_${PN} += "matrix-lighttpd-config lighttpd lighttpd-module-cgi lighttpd-module-compress lighttpd-module-expire php php-cgi php-cli matrix-gui-browser refresh-screen"

FILES_${PN} += "${MATRIX_BASE_DIR}/*"
