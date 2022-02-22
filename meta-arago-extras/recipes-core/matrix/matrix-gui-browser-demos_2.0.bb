SUMMARY = "Various Demo Browsers for Matrix v2"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.0"

inherit allarch

S = "${WORKDIR}/git/browser_apps"

# Make sure browser submenu and app images has been installed
RDEPENDS:${PN} += "matrix-gui-apps-images matrix-gui-submenus-browser"

FILES:${PN} += "${MATRIX_BASE_DIR}/*"
FILES:${PN} += "${bindir}/runGoogleChrome.sh"
