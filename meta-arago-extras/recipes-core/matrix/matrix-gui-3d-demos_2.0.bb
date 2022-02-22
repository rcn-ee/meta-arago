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

PACKAGES:append:omap-a15 = " \
            matrix-3d-demo-kmscube      \
            matrix-3d-demo-kmscubevideo \
"

PACKAGES:append:ti43x = " \
            matrix-3d-demo-kmscube \
"

PACKAGES:append:ti33x = " \
            matrix-3d-demo-kmscube \
"

PACKAGES:append:k3 = " \
            matrix-3d-demo-kmscube \
"

MATRIX_3D_DEMO_SGX_QAF_PARAM = "1000"

do_install:prepend() {
    find ${S} -name '*.desktop' -exec sed -i {} \
        -e "s|-qaf=[0-9]*|-qaf=${MATRIX_3D_DEMO_SGX_QAF_PARAM}|g" \;
}

3D_DEMOS_RDEPENDS_MATRIX = "matrix-gui-apps-images matrix-gui-submenus-3d"
3D_DEMOS_RDEPENDS = "${3D_DEMOS_RDEPENDS_MATRIX}"
3D_DEMOS_RDEPENDS:omap-a15 = "${3D_DEMOS_RDEPENDS_MATRIX} img-pvr-sdk"
3D_DEMOS_RDEPENDS:ti43x    = "${3D_DEMOS_RDEPENDS_MATRIX} img-pvr-sdk"
3D_DEMOS_RDEPENDS:ti33x    = "${3D_DEMOS_RDEPENDS_MATRIX} img-pvr-sdk"
3D_DEMOS_RDEPENDS:k3       = "${3D_DEMOS_RDEPENDS_MATRIX} img-pvr-sdk"

RDEPENDS:matrix-3d-demo-chameleon = "${3D_DEMOS_RDEPENDS}"
RDEPENDS:matrix-3d-demo-coverflow = "${3D_DEMOS_RDEPENDS}"
RDEPENDS:matrix-3d-demo-film      = "${3D_DEMOS_RDEPENDS}"
RDEPENDS:matrix-3d-demo-lantern   = "${3D_DEMOS_RDEPENDS}"
RDEPENDS:matrix-3d-demo-skull     = "${3D_DEMOS_RDEPENDS}"
RDEPENDS:matrix-3d-demo-shaders   = "${3D_DEMOS_RDEPENDS}"
RDEPENDS:matrix-3d-demo-vase      = "${3D_DEMOS_RDEPENDS}"
RDEPENDS:matrix-3d-demo-navigation    = "${3D_DEMOS_RDEPENDS}"
RDEPENDS:matrix-3d-demo-exampleui     = "${3D_DEMOS_RDEPENDS}"
RDEPENDS:matrix-3d-demo-kmscube       = "${3D_DEMOS_RDEPENDS_MATRIX} kmscube"
#RDEPENDS:matrix-3d-demo-kmscubevideo  = "${3D_DEMOS_RDEPENDS_MATRIX} omapdrmtest"
RDEPENDS:matrix-3d-demo-kmscubevideo  = "${3D_DEMOS_RDEPENDS_MATRIX}"

# Split the matrix files by 3d demos
FILES:matrix-3d-demo-chameleon = "${MATRIX_APP_DIR}/3d_chameleon/*"
FILES:matrix-3d-demo-coverflow = "${MATRIX_APP_DIR}/3d_coverflow/*"
FILES:matrix-3d-demo-film      = "${MATRIX_APP_DIR}/3d_film/*"
FILES:matrix-3d-demo-lantern   = "${MATRIX_APP_DIR}/3d_lantern/*"
FILES:matrix-3d-demo-skull     = "${MATRIX_APP_DIR}/3d_skull/*"
FILES:matrix-3d-demo-shaders   = "${MATRIX_APP_DIR}/3d_shaders/*"
FILES:matrix-3d-demo-vase      = "${MATRIX_APP_DIR}/3d_vase/*"
FILES:matrix-3d-demo-navigation       = "${MATRIX_APP_DIR}/3d_navigation/*"
FILES:matrix-3d-demo-exampleui        = "${MATRIX_APP_DIR}/3d_exampleui/*"
FILES:matrix-3d-demo-kmscube          = "${MATRIX_APP_DIR}/3d_kmscube/*"
FILES:matrix-3d-demo-kmscubevideo     = "${MATRIX_APP_DIR}/3d_kmscubevideo/*"

# Split the ${bindir} files by 3d demos
FILES:matrix-3d-demo-chameleon += "${bindir}/runOGLES2ChameleonMan.sh"
FILES:matrix-3d-demo-coverflow += "${bindir}/runOGLES2Coverflow.sh"
FILES:matrix-3d-demo-film      += "${bindir}/runOGLESFilmTV.sh"
FILES:matrix-3d-demo-lantern   += "${bindir}/runOGLES2MagicLantern.sh"
FILES:matrix-3d-demo-skull     += "${bindir}/runOGLESEvilSkull.sh"
FILES:matrix-3d-demo-shaders   += "${bindir}/runOGLES2Shaders.sh"
FILES:matrix-3d-demo-vase      += "${bindir}/runOGLESVase.sh"
FILES:matrix-3d-demo-navigation      += "${bindir}/runOGLES2Navigation.sh"
FILES:matrix-3d-demo-exampleui       += "${bindir}/runOGLES2ExampleUI.sh"
