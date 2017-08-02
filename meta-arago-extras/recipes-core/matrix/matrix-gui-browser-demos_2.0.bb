SUMMARY = "Various Demo Browsers for Matrix v2"
HOMEPAGE = "https://git.ti.com/matrix-gui-v2/matrix-gui-v2-apps"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.0"

inherit allarch

S = "${WORKDIR}/git/browser_apps"

# Make sure browser submenu and app images has been installed
RDEPENDS_${PN} += "matrix-gui-apps-images matrix-gui-submenus-browser"

FILES_${PN} += "${MATRIX_BASE_DIR}/*"
FILES_${PN} += "${bindir}/runGoogleChrome.sh"
