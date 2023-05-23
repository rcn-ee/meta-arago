DESCRIPTION = "PRU demo descriptions for Matrix v2"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.1"

inherit allarch

S = "${WORKDIR}/git/pru_apps"

# Make sure pru submenu and app images has been installed
RDEPENDS:${PN} += "matrix-gui-apps-images matrix-gui-submenus-pru"

FILES:${PN} += "${MATRIX_BASE_DIR}/*"
