DESCRIPTION = "3D demo descriptions for Matrix v2"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"
LICENSE = "CC-BY-SA"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.0"

S = "${WORKDIR}/git/3d_apps"

# Make sure 3D submenu has been installed and app images has been installed

# TODO: in the future we may want to consider putting this into the libgles
#       recipe directly.  Requires broad acceptance of matrix v2 though due
#       to the matrix-gui-submenus-3d dependency.  So if matrix v2 moves
#       into the same layer as libgles this may be acceptable, or perhaps
#       we can use an RRECOMMENDS instead.
RDEPENDS += "matrix-gui-apps-images matrix-gui-submenus-3d libgles-omap3-rawdemos"

FILES_${PN} += "${MATRIX_BASE_DIR}/*"
