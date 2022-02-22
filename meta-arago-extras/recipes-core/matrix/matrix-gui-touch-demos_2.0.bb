DESCRIPTION = "Touch demo descriptions for Matrix v2"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.0"

inherit allarch

S = "${WORKDIR}/git/touch_apps"

# Make sure touch submenu and app images has been installed
RDEPENDS:${PN} += "matrix-gui-apps-images matrix-gui-submenus-touch"

FILES:${PN} += "${MATRIX_BASE_DIR}/*"
