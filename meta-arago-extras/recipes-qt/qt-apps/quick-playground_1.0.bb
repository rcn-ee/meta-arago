DESCRIPTION = "Qt Quick Playground"
HOMEPAGE = "http://arago-project.org/git/projects/?p=qt4-demos.git;a=summary"
SECTION = "multimedia"
LICENSE = "Nokia"
LIC_FILES_CHKSUM = "file://Licence.txt;md5=7cc88160b55ec5db6c6c5bb8e3238c0b"

require recipes-core/matrix/matrix-gui-paths.inc

PR = "r3"

BRANCH = "master"
SRCREV = "b055cefbe2ecb9e8009c08abe2c9dcfe447cfc9d"

SRC_URI = "git://arago-project.org/git/projects/qt4-demos.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git/qml_playground"

inherit qt4e

do_install() {
    install -d ${D}/usr/bin 
    install -m 0755 runQMLplay.sh ${D}/usr/bin/
    install -d ${D}${MATRIX_APP_DIR}/qml_playground
    cp -r apps/qml_playground/*  ${D}${MATRIX_APP_DIR}/qml_playground
    install -m 0755 qtquickplayground ${D}${MATRIX_APP_DIR}/qml_playground/
}

PACKAGES += "matrix-gui-apps-quick-playground"

RDEPENDS_matrix-gui-apps-quick-playground  = "matrix-gui-apps-images matrix-gui-submenus-qt4 ${PN}"

# Add the matrix directory to the FILES
FILES_${PN} = "${MATRIX_APP_DIR}/qml_playground/qtquickplayground \
               /usr/bin/runQMLplay.sh"

# Add the .debug directory to the dbg package
FILES_${PN}-dbg += "${MATRIX_APP_DIR}/qml_playground/.debug"

FILES_matrix-gui-apps-quick-playground = "${MATRIX_APP_DIR}/*"
