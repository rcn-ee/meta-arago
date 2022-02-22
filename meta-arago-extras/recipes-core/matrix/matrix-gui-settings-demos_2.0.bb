DESCRIPTION = "Settings demo descriptions for Matrix v2"

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

RDEPENDS:${PN} += "${SETTINGS_DEMOS_RDEPENDS}"
RDEPENDS:matrix-gui-weston-terminal-demo += "${SETTINGS_DEMOS_RDEPENDS}"

FILES:${PN} += "${MATRIX_BASE_DIR}/*"
FILES:matrix-gui-weston-terminal-demo = "${MATRIX_APP_DIR}/terminal"
