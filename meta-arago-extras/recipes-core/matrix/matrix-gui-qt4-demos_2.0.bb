DESCRIPTION = "Qt4 demo descriptions for Matrix v2"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.1"

inherit allarch

S = "${WORKDIR}/git/qt4_apps"

# Make sure qt4 submenu and app images has been installed
RDEPENDS:${PN} += "matrix-gui-apps-images matrix-gui-submenus-qt4"

FILES:${PN} += "${MATRIX_BASE_DIR}/*"
