DESCRIPTION = "Qt Dual Camera Demo"
HOMEPAGE = "https://gitorious.org/dual-camera-demo/"
SECTION = "multimedia"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c7ca707704d3354a64feeb4f19f52eb5"

DEPENDS += "libdrm"
require recipes-core/matrix/matrix-gui-paths.inc

PR = "r5"

BRANCH = "drm"
SRCREV = "0c48cb66cc995420dfec2f1fd620c8977f0170aa"

SRC_URI = "git://gitorious.org/dual-camera-demo/dual-camera-demo.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

inherit qt-provider

export SDK_PATH_TARGET='${STAGING_DIR_HOST}'

# use the make targets already created in the Makefile.build files
do_install() {
    install -d ${D}/usr/bin
    install -d ${D}${MATRIX_APP_DIR}/dual-camera
    install dual_camera ${D}/usr/bin/dual_camera
    install dual_camera.sh ${D}/usr/bin/dual_camera.sh
    install matrix/* ${D}/${MATRIX_APP_DIR}/dual-camera
}

PACKAGES += "matrix-gui-apps-dual-camera"

RDEPENDS_${PN} += "libdrm libdrm-omap"

RDEPENDS_matrix-gui-apps-dual-camera  = "matrix-gui-apps-images matrix-gui-submenus-camera ${PN}"

# Add the matrix directory to the FILES
FILES_${PN} = "/usr/bin/*"

FILES_matrix-gui-apps-dual-camera = "${MATRIX_APP_DIR}/*"
