DESCRIPTION = "Camera loopback application for Matrix v2"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.1"

S = "${WORKDIR}/git/cameraloopback_apps"

# Make sure loopback application is compiled and app images has been installed
RDEPENDS:${PN} += "matrix-gui-apps-images av-examples"

FILES:${PN} += "${MATRIX_BASE_DIR}/*"
