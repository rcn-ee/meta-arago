DESCRIPTION = "Qt Dual Camera Demo"
HOMEPAGE = "https://gitorious.org/dual-camera-demo/"
SECTION = "multimedia"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://main.cpp;beginline=1;endline=18;md5=1e0116b09fc3d8f888286927eac06928"

require recipes-core/matrix/matrix-gui-paths.inc

PR = "r3"

BRANCH = "master"
SRCREV = "a877c704eba77fc09aec54211b387b95e62e523b"

SRC_URI = "git://gitorious.org/dual-camera-demo/dual-camera-demo.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

inherit qt-provider

# use the make targets already created in the Makefile.build files
do_install() {
    install -d ${D}/usr/bin
    install -d ${D}${MATRIX_APP_DIR}/arm_multimedia_dual-camera
    install dual_camera ${D}/usr/bin/dual_camera
    install dual_camera.sh ${D}/usr/bin/dual_camera.sh
    install matrix/* ${D}/${MATRIX_APP_DIR}/arm_multimedia_dual-camera
}

PACKAGES += "matrix-gui-apps-dual-camera"

RDEPENDS_matrix-gui-apps-dual-camera  = "matrix-gui-apps-images matrix-gui-submenus-multimedia ${PN}"

# Add the matrix directory to the FILES
FILES_${PN} = "/usr/bin/*"

FILES_matrix-gui-apps-dual-camera = "${MATRIX_APP_DIR}/*"
