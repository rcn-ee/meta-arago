DESCRIPTION = "3D demo descriptions for Matrix v2"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.4"

S = "${WORKDIR}/git/3d_apps"

PACKAGE_ARCH = "${MACHINE_ARCH}"

# Make sure 3D submenu has been installed and app images has been installed

# TODO: in the future we may want to consider putting this into the libgles
#       recipe directly.  Requires broad acceptance of matrix v2 though due
#       to the matrix-gui-submenus-3d dependency.  So if matrix v2 moves
#       into the same layer as libgles this may be acceptable, or perhaps
#       we can use an RRECOMMENDS instead.

PACKAGES = "matrix-3d-demo-chameleon \
            matrix-3d-demo-coverflow \
            matrix-3d-demo-film      \
            matrix-3d-demo-lantern   \
            matrix-3d-demo-skull     \
            matrix-3d-demo-shaders   \
            matrix-3d-demo-vase      \
            matrix-3d-demo-navigation   \
            matrix-3d-demo-exampleui    \
"

PACKAGES_append_omap-a15 = " \
            matrix-3d-demo-kmscube      \
            matrix-3d-demo-kmscubevideo \
"

MATRIX_3D_DEMO_SGX_QAF_PARAM = "1000"
MATRIX_3D_DEMO_SGX_QAF_PARAM_omap-a15 = "8000"

do_install_prepend() {
    find ${S} -name '*.desktop' -exec sed -i {} \
        -e "s|-qaf=[0-9]*|-qaf=${MATRIX_3D_DEMO_SGX_QAF_PARAM}|g" \;
}

3D_DEMOS_RDEPENDS_MATRIX = "matrix-gui-apps-images matrix-gui-submenus-3d"
3D_DEMOS_RDEPENDS = "${3D_DEMOS_RDEPENDS_MATRIX} libgles-omap3-rawdemos"
3D_DEMOS_RDEPENDS_omap-a15 = "${3D_DEMOS_RDEPENDS_MATRIX} img-pvr-sdk"
3D_DEMOS_RDEPENDS_ti43x    = "${3D_DEMOS_RDEPENDS_MATRIX} img-pvr-sdk"
3D_DEMOS_RDEPENDS_ti33x    = "${3D_DEMOS_RDEPENDS_MATRIX} img-pvr-sdk"

RDEPENDS_matrix-3d-demo-chameleon = "${3D_DEMOS_RDEPENDS}"
RDEPENDS_matrix-3d-demo-coverflow = "${3D_DEMOS_RDEPENDS}"
RDEPENDS_matrix-3d-demo-film      = "${3D_DEMOS_RDEPENDS}"
RDEPENDS_matrix-3d-demo-lantern   = "${3D_DEMOS_RDEPENDS}"
RDEPENDS_matrix-3d-demo-skull     = "${3D_DEMOS_RDEPENDS}"
RDEPENDS_matrix-3d-demo-shaders   = "${3D_DEMOS_RDEPENDS}"
RDEPENDS_matrix-3d-demo-vase      = "${3D_DEMOS_RDEPENDS}"
RDEPENDS_matrix-3d-demo-navigation    = "${3D_DEMOS_RDEPENDS}"
RDEPENDS_matrix-3d-demo-exampleui     = "${3D_DEMOS_RDEPENDS}"
RDEPENDS_matrix-3d-demo-kmscube       = "${3D_DEMOS_RDEPENDS_MATRIX} kmscube"
RDEPENDS_matrix-3d-demo-kmscubevideo  = "${3D_DEMOS_RDEPENDS_MATRIX} omapdrmtest"

# Split the matrix files by 3d demos
FILES_matrix-3d-demo-chameleon = "${MATRIX_APP_DIR}/3d_chameleon/*"
FILES_matrix-3d-demo-coverflow = "${MATRIX_APP_DIR}/3d_coverflow/*"
FILES_matrix-3d-demo-film      = "${MATRIX_APP_DIR}/3d_film/*"
FILES_matrix-3d-demo-lantern   = "${MATRIX_APP_DIR}/3d_lantern/*"
FILES_matrix-3d-demo-skull     = "${MATRIX_APP_DIR}/3d_skull/*"
FILES_matrix-3d-demo-shaders   = "${MATRIX_APP_DIR}/3d_shaders/*"
FILES_matrix-3d-demo-vase      = "${MATRIX_APP_DIR}/3d_vase/*"
FILES_matrix-3d-demo-navigation       = "${MATRIX_APP_DIR}/3d_navigation/*"
FILES_matrix-3d-demo-exampleui        = "${MATRIX_APP_DIR}/3d_exampleui/*"
FILES_matrix-3d-demo-kmscube          = "${MATRIX_APP_DIR}/3d_kmscube/*"
FILES_matrix-3d-demo-kmscubevideo     = "${MATRIX_APP_DIR}/3d_kmscubevideo/*"

# Split the ${bindir} files by 3d demos
FILES_matrix-3d-demo-chameleon += "${bindir}/runOGLES2ChameleonMan.sh"
FILES_matrix-3d-demo-coverflow += "${bindir}/runOGLES2Coverflow.sh"
FILES_matrix-3d-demo-film      += "${bindir}/runOGLESFilmTV.sh"
FILES_matrix-3d-demo-lantern   += "${bindir}/runOGLES2MagicLantern.sh"
FILES_matrix-3d-demo-skull     += "${bindir}/runOGLESEvilSkull.sh"
FILES_matrix-3d-demo-shaders   += "${bindir}/runOGLES2Shaders.sh"
FILES_matrix-3d-demo-vase      += "${bindir}/runOGLESVase.sh"
FILES_matrix-3d-demo-navigation      += "${bindir}/runOGLES2Navigation.sh"
FILES_matrix-3d-demo-exampleui       += "${bindir}/runOGLES2ExampleUI.sh"
