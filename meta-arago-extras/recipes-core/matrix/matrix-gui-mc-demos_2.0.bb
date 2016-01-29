DESCRIPTION = "Keystone multi-core demo descriptions for Matrix v2"
HOMEPAGE = "http://git.ti.com/matrix-gui-v2/matrix-gui-v2-apps"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.1"

inherit allarch

S = "${WORKDIR}/git/mc_demo_apps"

# Make sure demo submenu and app images has been installed.
MC_DEMOS_RDEPENDS = "matrix-gui-apps-images matrix-gui-submenus-mc-demo"

PACKAGES = "matrix-mc-demo-ipc \
            matrix-mc-demo-imageproc \
"

RDEPENDS_matrix-mc-demo-ipc        = "${MC_DEMOS_RDEPENDS}"
RDEPENDS_matrix-mc-demo-imageproc  = "${MC_DEMOS_RDEPENDS}"

FILES_matrix-mc-demo-ipc        = "${MATRIX_APP_DIR}/mc_demo_ipc/*"
FILES_matrix-mc-demo-imageproc  = "${MATRIX_APP_DIR}/mc_demo_imageproc/*"

FILES_matrix-mc-demo-ipc       += "${bindir}/mc_demo_ipc.sh"
FILES_matrix-mc-demo-imageproc += "${bindir}/mc_demo_imageproc.sh \
                                   ${bindir}/mc_run_dsp.sh \
"
