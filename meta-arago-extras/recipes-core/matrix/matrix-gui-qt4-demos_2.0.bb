DESCRIPTION = "Qt4 demo descriptions for Matrix v2"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"
LICENSE = "CC-BY-SA"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.0"

inherit allarch

S = "${WORKDIR}/git/qt4_apps"

# Make sure qt4 submenu and app images has been installed
RDEPENDS += "matrix-gui-apps-images matrix-gui-submenus-qt4"

FILES_${PN} += "${MATRIX_BASE_DIR}/*"
