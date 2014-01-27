DESCRIPTION = "Qt Dual Camera Demo"
HOMEPAGE = "https://gitorious.org/dual-camera-demo/"
SECTION = "multimedia"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://main.cpp;beginline=1;endline=18;md5=1e0116b09fc3d8f888286927eac06928"

require recipes-core/matrix/matrix-gui-paths.inc

PR = "r0"

BRANCH = "master"
SRCREV = "af299a206482562ceae8aa690a8b6644a3e0a66e"

SRC_URI = "git://gitorious.org/dual-camera-demo/dual-camera-demo.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

inherit qt-provider

# use the make targets already created in the Makefile.build files
do_install() {
    cd ${S} && make -f Makefile.build DESTDIR=${D} install_common
}

PACKAGES += "matrix-gui-apps-dual-camera"

RDEPENDS_matrix-gui-apps-dual-camera  = "matrix-gui-apps-images matrix-gui-submenus-multimedia ${PN}"

# Add the matrix directory to the FILES
FILES_${PN} = "/usr/bin/*"

FILES_matrix-gui-apps-dual-camera = "${MATRIX_APP_DIR}/*"
