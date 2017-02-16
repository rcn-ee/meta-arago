DESCRIPTION = "Multimedia demo descriptions for Matrix v2"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.7"

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
            matrix-multimedia-demo-ivahdh264dec \
            matrix-multimedia-demo-ivahdh264enc \
            matrix-multimedia-demo-ivahdmjpegenc \
            matrix-multimedia-demo-vip-vpe-ivahdmpeg4encdec \
            matrix-multimedia-demo-h265dec \
            matrix-multimedia-demo-dsp66imgproc \
            matrix-multimedia-demo-dsp66imgproc-f2f \
"

RDEPENDS_matrix-multimedia-demo-aac = "${MULTIMEDIA_RDEPENDS}"
RDEPENDS_matrix-multimedia-demo-audiocapture = "${MULTIMEDIA_RDEPENDS}"
RDEPENDS_matrix-multimedia-demo-h264dec      = "${MULTIMEDIA_RDEPENDS}"
RDEPENDS_matrix-multimedia-demo-mpeg4aacdec   = "${MULTIMEDIA_RDEPENDS}"
RDEPENDS_matrix-multimedia-demo-mpeg4dec     = "${MULTIMEDIA_RDEPENDS}"
RDEPENDS_matrix-multimedia-demo-ivahdh264dec             = "${MULTIMEDIA_RDEPENDS}"
RDEPENDS_matrix-multimedia-demo-ivahdh264enc             = "${MULTIMEDIA_RDEPENDS}"
RDEPENDS_matrix-multimedia-demo-ivahdmjpegenc            = "${MULTIMEDIA_RDEPENDS}"
RDEPENDS_matrix-multimedia-demo-vip-vpe-ivahdmpeg4encdec = "${MULTIMEDIA_RDEPENDS}"
RDEPENDS_matrix-multimedia-demo-h265dec      = "${MULTIMEDIA_RDEPENDS}"
RDEPENDS_matrix-multimedia-demo-dsp66imgproc  = "${MULTIMEDIA_RDEPENDS}"
RDEPENDS_matrix-multimedia-demo-dsp66imgproc-f2f  = "${MULTIMEDIA_RDEPENDS}"


# Split the matrix files by multimedia demos
FILES_matrix-multimedia-demo-aac = "${MATRIX_APP_DIR}/arm_multimedia_aacdec/*"
FILES_matrix-multimedia-demo-audiocapture = "${MATRIX_APP_DIR}/arm_multimedia_audiocapture/*"
FILES_matrix-multimedia-demo-h264dec      = "${MATRIX_APP_DIR}/arm_multimedia_h264dec/*"
FILES_matrix-multimedia-demo-mpeg4aacdec   = "${MATRIX_APP_DIR}/arm_multimedia_mpeg4aacdec/*"
FILES_matrix-multimedia-demo-mpeg4dec     = "${MATRIX_APP_DIR}/arm_multimedia_mpeg4dec/*"
FILES_matrix-multimedia-demo-ivahdh264dec                = "${MATRIX_APP_DIR}/ivahd_multimedia_h264dec/*"
FILES_matrix-multimedia-demo-ivahdh264enc                = "${MATRIX_APP_DIR}/ivahd_multimedia_h264enc/*"
FILES_matrix-multimedia-demo-ivahdmjpegenc               = "${MATRIX_APP_DIR}/ivahd_multimedia_mjpegenc/*"
FILES_matrix-multimedia-demo-vip-vpe-ivahdmpeg4encdec    = "${MATRIX_APP_DIR}/ivahd_multimedia_vip_vpe_mpeg4encdec/*"
FILES_matrix-multimedia-demo-h265dec      = "${MATRIX_APP_DIR}/arm_multimedia_h265dec/*"
FILES_matrix-multimedia-demo-dsp66imgproc     = "${MATRIX_APP_DIR}/dsp66_multimedia_imgproc/*"
FILES_matrix-multimedia-demo-dsp66imgproc-f2f     = "${MATRIX_APP_DIR}/dsp66_multimedia_imgproc_f2f/*"

# Split the ${bindir} files by multimedia demos
FILES_matrix-multimedia-demo-aac += "${bindir}/runAACDec.sh"
FILES_matrix-multimedia-demo-audiocapture += "${bindir}/runAudioCapture.sh"
FILES_matrix-multimedia-demo-h264dec      += "${bindir}/runH264Dec.sh"
FILES_matrix-multimedia-demo-mpeg4aacdec   += "${bindir}/runMpeg4AacDec.sh"
FILES_matrix-multimedia-demo-mpeg4dec     += "${bindir}/runMpeg4Dec.sh"
FILES_matrix-multimedia-demo-ivahdh264dec               += "${bindir}/runIvahdH264Dec.sh"
FILES_matrix-multimedia-demo-ivahdh264enc               += "${bindir}/runIvahdH264Enc.sh"
FILES_matrix-multimedia-demo-ivahdmjpegenc              += "${bindir}/runIvahdMjpegEnc.sh"
FILES_matrix-multimedia-demo-vip-vpe-ivahdmpeg4encdec   += "${bindir}/runIvahdVipVpeMpeg4EncDec.sh"
FILES_matrix-multimedia-demo-h265dec      += "${bindir}/runH265Dec.sh"
FILES_matrix-multimedia-demo-dsp66imgproc    += "${bindir}/runDsp66ImgProc.sh"
FILES_matrix-multimedia-demo-dsp66imgproc-f2f    += "${bindir}/runDsp66ImgProcSave2File.sh"
