DESCRIPTION = "Qt Dual Camera Demo"
HOMEPAGE = "https://gitorious.org/dual-camera-demo/"
SECTION = "multimedia"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://main.cpp;md5=424a1b7299bcd2c5fad3b05493dd8898"

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
