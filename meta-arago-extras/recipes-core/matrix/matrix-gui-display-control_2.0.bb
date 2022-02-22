DESCRIPTION = "Display control descriptions for Matrix v2"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.1"

inherit allarch

S = "${WORKDIR}/git/displaycontrol_apps"

# Make sure display submenu and app images has been installed
RDEPENDS:${PN} += "matrix-gui-apps-images matrix-gui-submenus-display"

FILES:${PN} += "${MATRIX_BASE_DIR}/*"
