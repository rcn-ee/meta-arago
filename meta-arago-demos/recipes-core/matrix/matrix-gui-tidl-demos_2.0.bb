DESCRIPTION = "Deep learning vision demo descriptions for Matrix v2"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.1"

inherit allarch

S = "${WORKDIR}/git/tidl_apps"

# Make sure tidl submenu and app images has been installed
TIDLDEMO_RDEPENDS += "matrix-gui-apps-images matrix-gui-submenus-tidl"

FILES:${PN} += "${MATRIX_BASE_DIR}/*"

PACKAGES = "matrix-tidl-demo-staticimg \
            matrix-tidl-demo-staticimg-lg2 \
            matrix-tidl-demo-staticimg-dsponly \
            matrix-tidl-demo-pnexamples \
            matrix-tidl-demo-livecam \
            matrix-tidl-demo-livecam-lg2 \
            matrix-tidl-demo-dogbreeds \
            matrix-tidl-demo-objdet \
            matrix-tidl-demo-objdet-livecam \
            matrix-tidl-demo-segment \
"

RDEPENDS:matrix-tidl-demo-staticimg = " \
    ${TIDLDEMO_RDEPENDS} \
"

RDEPENDS:matrix-tidl-demo-staticimg-lg2 = " \
    ${TIDLDEMO_RDEPENDS} \
"

RDEPENDS:matrix-tidl-demo-staticimg-dsponly = " \
    ${TIDLDEMO_RDEPENDS} \
"

RDEPENDS:matrix-tidl-demo-pnexamples = " \
    ${TIDLDEMO_RDEPENDS} \
"

RDEPENDS:matrix-tidl-demo-livecam = " \
    ${TIDLDEMO_RDEPENDS} \
"

RDEPENDS:matrix-tidl-demo-livecam-lg2 = " \
    ${TIDLDEMO_RDEPENDS} \
"

RDEPENDS:matrix-tidl-demo-dogbreeds = " \
    ${TIDLDEMO_RDEPENDS} \
"

RDEPENDS:matrix-tidl-demo-objdet = " \
    ${TIDLDEMO_RDEPENDS} \
"

RDEPENDS:matrix-tidl-demo-objdet-livecam = " \
    ${TIDLDEMO_RDEPENDS} \
"

RDEPENDS:matrix-tidl-demo-segment = " \
    ${TIDLDEMO_RDEPENDS} \
"

FILES:matrix-tidl-demo-staticimg = "${MATRIX_APP_DIR}/tidl_demo_staticimg/*"
FILES:matrix-tidl-demo-staticimg += "${bindir}/runTidlStaticImg.sh"

FILES:matrix-tidl-demo-staticimg-lg2 = "${MATRIX_APP_DIR}/tidl_demo_staticimg_lg2/*"
FILES:matrix-tidl-demo-staticimg-lg2 += "${bindir}/runTidlStaticImg_lg2.sh"

FILES:matrix-tidl-demo-staticimg-dsponly = "${MATRIX_APP_DIR}/tidl_demo_staticimg_dsponly/*"
FILES:matrix-tidl-demo-staticimg-dsponly += "${bindir}/runTidlStaticImg_dsponly.sh"

FILES:matrix-tidl-demo-pnexamples = "${MATRIX_APP_DIR}/tidl_demo_pnexamples/*"
FILES:matrix-tidl-demo-pnexamples += "${bindir}/runTidlPnExamples.sh"

FILES:matrix-tidl-demo-livecam   = "${MATRIX_APP_DIR}/tidl_demo_livecam/*"
FILES:matrix-tidl-demo-livecam   += "${bindir}/runTidlLiveCam.sh"

FILES:matrix-tidl-demo-livecam-lg2  = "${MATRIX_APP_DIR}/tidl_demo_livecam_lg2/*"
FILES:matrix-tidl-demo-livecam-lg2  += "${bindir}/runTidlLiveCam_lg2.sh"

FILES:matrix-tidl-demo-dogbreeds = "${MATRIX_APP_DIR}/tidl_demo_dogbreeds/*"
FILES:matrix-tidl-demo-dogbreeds += "${bindir}/runTidlDogBreeds.sh"

FILES:matrix-tidl-demo-objdet   = "${MATRIX_APP_DIR}/tidl_demo_objdet/*"
FILES:matrix-tidl-demo-objdet   += "${bindir}/runTidlObjdet.sh"

FILES:matrix-tidl-demo-objdet-livecam   = "${MATRIX_APP_DIR}/tidl_demo_objdet_livecam/*"
FILES:matrix-tidl-demo-objdet-livecam   += "${bindir}/runTidlObjdet_livecam.sh"

FILES:matrix-tidl-demo-segment   = "${MATRIX_APP_DIR}/tidl_demo_segment/*"
FILES:matrix-tidl-demo-segment   += "${bindir}/runTidlSegment.sh"
