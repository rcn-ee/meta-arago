DESCRIPTION = "Multimedia demo descriptions for Matrix v2"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"
LICENSE = "CC-BY-SA"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.3"

inherit allarch

S = "${WORKDIR}/git/multimedia_apps"

# Make sure multimedia submenu and app images has been installed
MULTIMEDIA_RDEPENDS += "matrix-gui-apps-images matrix-gui-submenus-multimedia amsdk-av-files"

FILES_${PN} += "${MATRIX_BASE_DIR}/*"

PACKAGES = "matrix-multimedia-demo-aac \
            matrix-multimedia-demo-audiocapture \
            matrix-multimedia-demo-h264dec      \
            matrix-multimedia-demo-mpeg4aacdec   \
            matrix-multimedia-demo-mpeg4dec     \
"

RDEPENDS_matrix-multimedia-demo-aac = "${MULTIMEDIA_RDEPENDS}"
RDEPENDS_matrix-multimedia-demo-audiocapture = "${MULTIMEDIA_RDEPENDS}"
RDEPENDS_matrix-multimedia-demo-h264dec      = "${MULTIMEDIA_RDEPENDS}"
RDEPENDS_matrix-multimedia-demo-mpeg4aacdec   = "${MULTIMEDIA_RDEPENDS}"
RDEPENDS_matrix-multimedia-demo-mpeg4dec     = "${MULTIMEDIA_RDEPENDS}"


# Split the matrix files by multimedia demos
FILES_matrix-multimedia-demo-aac = "${MATRIX_APP_DIR}/arm_multimedia_aacdec/*"
FILES_matrix-multimedia-demo-audiocapture = "${MATRIX_APP_DIR}/arm_multimedia_audiocapture/*"
FILES_matrix-multimedia-demo-h264dec      = "${MATRIX_APP_DIR}/arm_multimedia_h264dec/*"
FILES_matrix-multimedia-demo-mpeg4aacdec   = "${MATRIX_APP_DIR}/arm_multimedia_mpeg4aacdec/*"
FILES_matrix-multimedia-demo-mpeg4dec     = "${MATRIX_APP_DIR}/arm_multimedia_mpeg4dec/*"

# Split the ${bindir} files by multimedia demos
FILES_matrix-multimedia-demo-aac += "${bindir}/runAACDec.sh"
FILES_matrix-multimedia-demo-audiocapture += "${bindir}/runAudioCapture.sh"
FILES_matrix-multimedia-demo-h264dec      += "${bindir}/runH264Dec.sh"
FILES_matrix-multimedia-demo-mpeg4aacdec   += "${bindir}/runMpeg4AacDec.sh"
FILES_matrix-multimedia-demo-mpeg4dec     += "${bindir}/runMpeg4Dec.sh"
