DESCRIPTION = "Wifi demo descriptions for Matrix v2"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.1"

inherit allarch

S = "${WORKDIR}/git/wifi_apps"

# Make sure wifi submenu and app images has been installed
RDEPENDS:${PN} += "matrix-gui-apps-images matrix-gui-submenus-wifi"

FILES:${PN} += "${MATRIX_BASE_DIR}/*"
