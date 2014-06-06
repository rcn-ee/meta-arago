DESCRIPTION = "Image Gallery"
HOMEPAGE = "https://gitorious.org/image-gallery"
SECTION = "multimedia"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9c57cc1cdee589f97cbba69e95a89a15"

require recipes-core/matrix/matrix-gui-paths.inc

inherit qt-provider

PR = "r0"

BRANCH = "master"
SRCREV = "8901d7c598b277e4e26a5abbcb859e7ceebd340a"

SRC_URI = "git://gitorious.org/image-gallery/image-gallery.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git/"

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${B}/image-gallery ${D}/${bindir}/image-gallery
	install -d ${D}${MATRIX_APP_DIR}/qt-image-gallery
	cp -rf matrix-files/*  ${D}${MATRIX_APP_DIR}/qt-image-gallery
}

PACKAGES += "matrix-gui-apps-image-gallery"

RDEPENDS_matrix-gui-apps-image-gallery  = "matrix-gui-apps-images matrix-gui-submenus-camera ${PN}"

FILES_matrix-gui-apps-image-gallery += "${MATRIX_APP_DIR}/*"
