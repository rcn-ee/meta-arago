DESCRIPTION = "Settings demo descriptions for Matrix v2"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.3"

inherit allarch

S = "${WORKDIR}/git/settings_apps"

PACKAGES =+ "matrix-gui-weston-terminal-demo"

# Make sure setting submenu and app images has been installed
SETTINGS_DEMOS_RDEPENDS = " \
    matrix-gui-apps-images \
    matrix-gui-submenus-settings \
    am-sysinfo \
"

RDEPENDS_${PN} += "${SETTINGS_DEMOS_RDEPENDS}"
RDEPENDS_matrix-gui-weston-terminal-demo += "${SETTINGS_DEMOS_RDEPENDS}"

FILES_${PN} += "${MATRIX_BASE_DIR}/*"
FILES_matrix-gui-weston-terminal-demo = "${MATRIX_APP_DIR}/terminal"
