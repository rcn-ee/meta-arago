DESCRIPTION = "Arm Benchmarks Applications for Matrix v2"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.8"

inherit allarch

S = "${WORKDIR}/git/arm_apps"

# Make sure arm submenu and app images has been installed
RDEPENDS:${PN} += "matrix-gui-apps-images matrix-gui-submenus-arm"

# Make sure the benchmarks have been installed
RDEPENDS:${PN} += "arm-benchmarks lmbench nbench-byte matrix-gui-helper-scripts"

FILES:${PN} += "${MATRIX_BASE_DIR}/*"
