DESCRIPTION = "Multimedia demo descriptions for Matrix v2"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"
LICENSE = "CC-BY-SA"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.1"

inherit allarch

S = "${WORKDIR}/git/multimedia_apps"

# Make sure multimedia submenu and app images has been installed
RDEPENDS += "matrix-gui-apps-images matrix-gui-submenus-multimedia amsdk-av-files"

FILES_${PN} += "${MATRIX_BASE_DIR}/*"
