DESCRIPTION = "3D demo descriptions for Matrix v2"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"
LICENSE = "CC-BY-SA"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.2"

S = "${WORKDIR}/git/3d_apps"

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
"

3D_DEMOS_RDEPENDS = "matrix-gui-apps-images matrix-gui-submenus-3d libgles-omap3-rawdemos"

RDEPENDS_matrix-3d-demo-chameleon = "${3D_DEMOS_RDEPENDS}"
RDEPENDS_matrix-3d-demo-coverflow = "${3D_DEMOS_RDEPENDS}"
RDEPENDS_matrix-3d-demo-film      = "${3D_DEMOS_RDEPENDS}"
RDEPENDS_matrix-3d-demo-lantern   = "${3D_DEMOS_RDEPENDS}"
RDEPENDS_matrix-3d-demo-skull     = "${3D_DEMOS_RDEPENDS}"
RDEPENDS_matrix-3d-demo-shaders   = "${3D_DEMOS_RDEPENDS}"
RDEPENDS_matrix-3d-demo-vase      = "${3D_DEMOS_RDEPENDS}"

# Split the matrix files by 3d demos
FILES_matrix-3d-demo-chameleon = "${MATRIX_APP_DIR}/3d_chameleon/*"
FILES_matrix-3d-demo-coverflow = "${MATRIX_APP_DIR}/3d_coverflow/*"
FILES_matrix-3d-demo-film      = "${MATRIX_APP_DIR}/3d_film/*"
FILES_matrix-3d-demo-lantern   = "${MATRIX_APP_DIR}/3d_lantern/*"
FILES_matrix-3d-demo-skull     = "${MATRIX_APP_DIR}/3d_skull/*"
FILES_matrix-3d-demo-shaders   = "${MATRIX_APP_DIR}/3d_shaders/*"
FILES_matrix-3d-demo-vase      = "${MATRIX_APP_DIR}/3d_vase/*"

# Split the ${bindir} files by 3d demos
FILES_matrix-3d-demo-chameleon += "${bindir}/runOGLES2ChameleonMan.sh"
FILES_matrix-3d-demo-coverflow += "${bindir}/runOGLES2Coverflow.sh"
FILES_matrix-3d-demo-film      += "${bindir}/runOGLESFilmTV.sh"
FILES_matrix-3d-demo-lantern   += "${bindir}/runOGLES2MagicLantern.sh"
FILES_matrix-3d-demo-skull     += "${bindir}/runOGLESEvilSkull.sh"
FILES_matrix-3d-demo-shaders   += "${bindir}/runOGLES2Shaders.sh"
FILES_matrix-3d-demo-vase      += "${bindir}/runOGLESVase.sh"
