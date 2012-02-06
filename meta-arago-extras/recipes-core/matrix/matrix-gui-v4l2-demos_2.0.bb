DESCRIPTION = "V4l2 demo descriptions for Matrix v2"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"
LICENSE = "CC-BY-SA"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.0"

inherit allarch

S = ${WORKDIR}/git/v4l2_apps

# Make sure display submenu and app images has been installed
RDEPENDS += matrix-gui-apps-images matrix-gui-submenus-display

FILES_${PN} += "${MATRIX_BASE_DIR}/*"
