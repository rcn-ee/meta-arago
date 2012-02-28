DESCRIPTION = "Arm Benchmarks Applications for Matrix v2"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"
LICENSE = "CC-BY-SA"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.1"

inherit allarch

S = ${WORKDIR}/git/arm_apps

# Make sure arm submenu and app images has been installed
RDEPENDS += matrix-gui-apps-images matrix-gui-submenus-arm

# Make sure the benchmarks have been installed
RDEPENDS += "arm-benchmarks lmbench"

# Uncomment when nbench-byte (BYTEmark) is available in OE-Core
#RDEPENDS += "nbench-byte"

FILES_${PN} += "${MATRIX_BASE_DIR}/*"
