DESCRIPTION = "Arm Benchmarks Applications for Matrix v2"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.6"

inherit allarch

S = "${WORKDIR}/git/arm_apps"

# Make sure arm submenu and app images has been installed
RDEPENDS_${PN} += "matrix-gui-apps-images matrix-gui-submenus-arm"

# Make sure the benchmarks have been installed
RDEPENDS_${PN} += "arm-benchmarks lmbench nbench-byte matrix-gui-helper-scripts"

FILES_${PN} += "${MATRIX_BASE_DIR}/*"
