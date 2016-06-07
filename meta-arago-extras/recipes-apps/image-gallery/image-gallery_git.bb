DESCRIPTION = "Image Gallery"
HOMEPAGE = "https://gitorious.org/image-gallery"
SECTION = "multimedia"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9c57cc1cdee589f97cbba69e95a89a15"

require recipes-core/matrix/matrix-gui-paths.inc

inherit qt-provider

PR = "r5"

BRANCH = "master"
SRCREV = "d9a2f2e27f59f3bbcde91efc6afba8cd04f3b4be"

SRC_URI = "git://git.ti.com/matrix-gui-v2/image-gallery.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git/"

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${B}/image-gallery ${D}/${bindir}/image-gallery
	install -d ${D}${MATRIX_APP_DIR}/qt-image-gallery
	cp -rf ${S}/matrix-files/*  ${D}${MATRIX_APP_DIR}/qt-image-gallery
}

PACKAGES += "matrix-gui-apps-image-gallery"

RDEPENDS_matrix-gui-apps-image-gallery  = "matrix-gui-apps-images matrix-gui-submenus-camera ${PN}"

FILES_matrix-gui-apps-image-gallery += "${MATRIX_APP_DIR}/*"
