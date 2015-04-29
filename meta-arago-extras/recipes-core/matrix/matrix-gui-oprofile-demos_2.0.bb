DESCRIPTION = "Oprofile demo applications for Matrix v2"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.3"

inherit allarch

S = "${WORKDIR}/git/oprofile_apps"

# Make sure profiling submenu and app images  has been installed
# Include am-sysinfo because that package has the sample
# executables for profiling.
RDEPENDS_${PN} += "matrix-gui-apps-images matrix-gui-submenus-oprofile oprofile oprofile-example"

FILES_${PN} += "${MATRIX_BASE_DIR}/*"
