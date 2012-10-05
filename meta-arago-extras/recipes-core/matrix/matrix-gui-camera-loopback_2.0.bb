DESCRIPTION = "Camera loopback application for Matrix v2"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"
LICENSE = "CC-BY-SA"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.1"

S = "${WORKDIR}/git/cameraloopback_apps"

# Make sure loopback application is compiled and app images has been installed
RDEPENDS_${PN} += "matrix-gui-apps-images av-examples"

FILES_${PN} += "${MATRIX_BASE_DIR}/*"
