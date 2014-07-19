DESCRIPTION = "Settings demo descriptions for Matrix v2"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.1"

inherit allarch

S = "${WORKDIR}/git/settings_apps"

# Make sure setting submenu and app images has been installed
RDEPENDS_${PN} += "matrix-gui-apps-images matrix-gui-submenus-settings am-sysinfo"

FILES_${PN} += "${MATRIX_BASE_DIR}/*"
