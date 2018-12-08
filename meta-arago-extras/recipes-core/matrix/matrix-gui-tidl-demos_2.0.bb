DESCRIPTION = "Deep learning vision demo descriptions for Matrix v2"
HOMEPAGE = "http://git.ti.com/matrix-gui-v2/matrix-gui-v2-apps"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.1"

inherit allarch

S = "${WORKDIR}/git/tidl_apps"

# Make sure tidl submenu and app images has been installed
TIDLDEMO_RDEPENDS += "matrix-gui-apps-images matrix-gui-submenus-tidl"

FILES_${PN} += "${MATRIX_BASE_DIR}/*"

PACKAGES = "matrix-tidl-demo-staticimg \
            matrix-tidl-demo-staticimg-lg2 \
            matrix-tidl-demo-staticimg-dsponly \
            matrix-tidl-demo-pnexamples \
            matrix-tidl-demo-livecam \
            matrix-tidl-demo-livecam-lg2 \
            matrix-armnn-demo-staticimg \
            matrix-armnn-demo-livecam \
"

RDEPENDS_matrix-tidl-demo-staticimg = " \
    ${TIDLDEMO_RDEPENDS} \
"

RDEPENDS_matrix-tidl-demo-staticimg-lg2 = " \
    ${TIDLDEMO_RDEPENDS} \
"

RDEPENDS_matrix-tidl-demo-staticimg-dsponly = " \
    ${TIDLDEMO_RDEPENDS} \
"

RDEPENDS_matrix-tidl-demo-pnexamples = " \
    ${TIDLDEMO_RDEPENDS} \
"

RDEPENDS_matrix-tidl-demo-livecam = " \
    ${TIDLDEMO_RDEPENDS} \
"

RDEPENDS_matrix-tidl-demo-livecam-lg2 = " \
    ${TIDLDEMO_RDEPENDS} \
"

RDEPENDS_matrix-armnn-demo-staticimg = " \
    ${TIDLDEMO_RDEPENDS} \
"

RDEPENDS_matrix-armnn-demo-livecam = " \
    ${TIDLDEMO_RDEPENDS} \
"

FILES_matrix-tidl-demo-staticimg = "${MATRIX_APP_DIR}/tidl_demo_staticimg/*"
FILES_matrix-tidl-demo-staticimg += "${bindir}/runTidlStaticImg.sh"

FILES_matrix-tidl-demo-staticimg-lg2 = "${MATRIX_APP_DIR}/tidl_demo_staticimg_lg2/*"
FILES_matrix-tidl-demo-staticimg-lg2 += "${bindir}/runTidlStaticImg_lg2.sh"

FILES_matrix-tidl-demo-staticimg-dsponly = "${MATRIX_APP_DIR}/tidl_demo_staticimg_dsponly/*"
FILES_matrix-tidl-demo-staticimg-dsponly += "${bindir}/runTidlStaticImg_dsponly.sh"

FILES_matrix-tidl-demo-pnexamples = "${MATRIX_APP_DIR}/tidl_demo_pnexamples/*"
FILES_matrix-tidl-demo-pnexamples += "${bindir}/runTidlPnExamples.sh"

FILES_matrix-tidl-demo-livecam   = "${MATRIX_APP_DIR}/tidl_demo_livecam/*"
FILES_matrix-tidl-demo-livecam   += "${bindir}/runTidlLiveCam.sh"

FILES_matrix-tidl-demo-livecam-lg2  = "${MATRIX_APP_DIR}/tidl_demo_livecam_lg2/*"
FILES_matrix-tidl-demo-livecam-lg2  += "${bindir}/runTidlLiveCam_lg2.sh"

FILES_matrix-armnn-demo-staticimg = "${MATRIX_APP_DIR}/armnn_demo_staticimg/*"
FILES_matrix-armnn-demo-staticimg += "${bindir}/runArmnnStaticImg.sh"

FILES_matrix-armnn-demo-livecam = "${MATRIX_APP_DIR}/armnn_demo_livecam/*"
FILES_matrix-armnn-demo-livecam += "${bindir}/runArmnnLiveCam.sh"
