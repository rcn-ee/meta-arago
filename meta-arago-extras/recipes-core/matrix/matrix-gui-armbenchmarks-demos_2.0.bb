DESCRIPTION = "Arm Benchmarks Applications for Matrix v2"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"
LICENSE = "CC-BY-SA"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.5"

inherit allarch

S = "${WORKDIR}/git/arm_apps"

# Make sure arm submenu and app images has been installed
RDEPENDS_${PN} += "matrix-gui-apps-images matrix-gui-submenus-arm"

# Make sure the benchmarks have been installed
RDEPENDS_${PN} += "arm-benchmarks lmbench nbench-byte"

FILES_${PN} += "${MATRIX_BASE_DIR}/*"
