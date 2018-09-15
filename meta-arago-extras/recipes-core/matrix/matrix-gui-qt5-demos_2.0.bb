DESCRIPTION = "Qt5 demo descriptions for Matrix v2"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.0"

inherit allarch

S = "${WORKDIR}/git/qt5_apps"

# Make sure qt5 submenu and app images has been installed
QT5_RDEPENDS += "matrix-gui-apps-images matrix-gui-submenus-qt5"

FILES_${PN} += "${MATRIX_BASE_DIR}/*"
PACKAGES = "matrix-qt5-demo-animated \
            matrix-qt5-demo-browser \
            matrix-qt5-demo-calculator \
            matrix-qt5-demo-deform \
            matrix-qt5-demo-webkit-browser \
"

RDEPENDS_matrix-qt5-demo-animated = "${QT5_RDEPENDS}"
RDEPENDS_matrix-qt5-demo-browser = "${QT5_RDEPENDS}"
RDEPENDS_matrix-qt5-demo-calculator = "${QT5_RDEPENDS}"
RDEPENDS_matrix-qt5-demo-deform = "${QT5_RDEPENDS}"
RDEPENDS_matrix-qt5-demo-webkit-browser = "${QT5_RDEPENDS}"

# Split the matrix files by qt5 demos
FILES_matrix-qt5-demo-animated = "${MATRIX_APP_DIR}/qt5_animated_tiles/*"
FILES_matrix-qt5-demo-browser = "${MATRIX_APP_DIR}/qt5_browser/*"
FILES_matrix-qt5-demo-calculator = "${MATRIX_APP_DIR}/qt5_calculator/*"
FILES_matrix-qt5-demo-deform = "${MATRIX_APP_DIR}/qt5_deform/*"
FILES_matrix-qt5-demo-webkit-browser = "${MATRIX_APP_DIR}/qt5_webkit_browser/*"
