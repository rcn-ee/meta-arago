DESCRIPTION = "Qt Quick Playground"
HOMEPAGE = "http://arago-project.org/git/projects/?p=qt4-demos.git;a=summary"
SECTION = "multimedia"
LICENSE = "Nokia"
LIC_FILES_CHKSUM = "file://Licence.txt;md5=7cc88160b55ec5db6c6c5bb8e3238c0b"

require recipes-core/matrix/matrix-gui-paths.inc

PR = "r0"

BRANCH = "master"
SRCREV = "49bb5b7e1df2f61fc361b7d83a6ec838ffc5381c"

SRC_URI = "git://arago-project.org/git/projects/qt4-demos.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git/qml_playground"

inherit qt4e

# use the make targets already created in the Makefile.build files
do_install() {
    make -f Makefile.build DESTDIR=${D} install_common
}

PACKAGES += "matrix-gui-apps-quick-playground"

RDEPENDS_matrix-gui-apps-quick-playground  = "matrix-gui-apps-images matrix-gui-submenus-qt4 ${PN}"

# Add the matrix directory to the FILES
FILES_${PN} = "${MATRIX_APP_DIR}/qml_playground/qtquickplayground \
               /usr/bin/runQMLplay.sh"

# Add the .debug directory to the dbg package
FILES_${PN}-dbg += "${MATRIX_APP_DIR}/qml_playground/.debug"

FILES_matrix-gui-apps-quick-playground = "${MATRIX_APP_DIR}/*"
