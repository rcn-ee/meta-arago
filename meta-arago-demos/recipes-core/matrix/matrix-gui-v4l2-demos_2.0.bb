DESCRIPTION = "V4l2 demo descriptions for Matrix v2"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.2"

inherit allarch

S = "${WORKDIR}/git/v4l2_apps"

# Make sure display submenu and app images has been installed
RDEPENDS:${PN} += "matrix-gui-apps-images matrix-gui-submenus-display av-examples"

FILES:${PN} += "${MATRIX_BASE_DIR}/*"
