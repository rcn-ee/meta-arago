DESCRIPTION = "Keystone multi-core demo descriptions for Matrix v2"
HOMEPAGE = "http://git.ti.com/matrix-gui-v2/matrix-gui-v2-apps"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.0"

inherit allarch

S = "${WORKDIR}/git/mc_demo_apps"

# Make sure demo submenu and app images has been installed.
RDEPENDS_${PN} += "matrix-gui-apps-images matrix-gui-submenus-mc-demo"

FILES_${PN} += "${MATRIX_BASE_DIR}/apps/ \
		${bindir}/mc_demo_imageproc.sh \
		${bindir}/mc_run_dsp.sh \
		${bindir}/mc_demo_ipc.sh \
"
