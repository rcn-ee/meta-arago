DESCRIPTION = "USB demo descriptions for Matrix v2"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.3"

inherit allarch

S = "${WORKDIR}/git/usb_apps"

# Make sure usb submenu and app images has been installed
RDEPENDS:${PN} += "matrix-gui-apps-images matrix-gui-submenus-usb bonnie++ matrix-gui-helper-scripts"

FILES:${PN} += "${MATRIX_BASE_DIR}/*"
