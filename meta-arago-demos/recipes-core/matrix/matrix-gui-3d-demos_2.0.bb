DESCRIPTION = "3D demo descriptions for Matrix v2"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.9"

S = "${WORKDIR}/git/3d_apps"

PACKAGE_ARCH = "${MACHINE_ARCH}"

# Make sure 3D submenu has been installed and app images has been installed

# TODO: in the future we may want to consider putting this into the libgles
#       recipe directly.  Requires broad acceptance of matrix v2 though due
#       to the matrix-gui-submenus-3d dependency.  So if matrix v2 moves
#       into the same layer as libgles this may be acceptable, or perhaps
#       we can use an RRECOMMENDS instead.

PACKAGES = " \
            matrix-3d-demo-kmscube      \
"

PACKAGES:append:omap-a15 = " \
            matrix-3d-demo-kmscubevideo \
"

MATRIX_3D_DEMO_SGX_QAF_PARAM = "1000"

do_install:prepend() {
    find ${S} -name '*.desktop' -exec sed -i {} \
        -e "s|-qaf=[0-9]*|-qaf=${MATRIX_3D_DEMO_SGX_QAF_PARAM}|g" \;
}

3D_DEMOS_RDEPENDS_MATRIX = "matrix-gui-apps-images matrix-gui-submenus-3d"
3D_DEMOS_RDEPENDS = "${3D_DEMOS_RDEPENDS_MATRIX}"
3D_DEMOS_RDEPENDS:omap-a15 = "${3D_DEMOS_RDEPENDS_MATRIX}"
3D_DEMOS_RDEPENDS:ti43x    = "${3D_DEMOS_RDEPENDS_MATRIX}"
3D_DEMOS_RDEPENDS:ti33x    = "${3D_DEMOS_RDEPENDS_MATRIX}"
3D_DEMOS_RDEPENDS:k3       = "${3D_DEMOS_RDEPENDS_MATRIX}"

RDEPENDS:matrix-3d-demo-kmscube       = "${3D_DEMOS_RDEPENDS_MATRIX} kmscube"
#RDEPENDS:matrix-3d-demo-kmscubevideo  = "${3D_DEMOS_RDEPENDS_MATRIX} omapdrmtest"
RDEPENDS:matrix-3d-demo-kmscubevideo  = "${3D_DEMOS_RDEPENDS_MATRIX}"

# Split the matrix files by 3d demos
FILES:matrix-3d-demo-kmscube          = "${MATRIX_APP_DIR}/3d_kmscube/*"
FILES:matrix-3d-demo-kmscubevideo     = "${MATRIX_APP_DIR}/3d_kmscubevideo/*"
