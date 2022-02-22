DESCRIPTION = "Machine vision demo descriptions for Matrix v2"

require recipes-core/matrix/matrix-gui-apps-git.inc

PR = "${INC_PR}.4"

PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/git/machinevision_apps"

# Make sure machinevision submenu and app images has been installed
MACHINEVISION_RDEPENDS += "matrix-gui-apps-images matrix-gui-submenus-machinevision"

BARCODE_RDEPENDS = ""
#BARCODE_RDEPENDS = " \
#    ${@['','barcode-roi'][oe.utils.all_distro_features(d, 'opencv', True, False) and bb.utils.contains('MACHINE_FEATURES', 'dsp', True, False, d)]} \
#"

FILES:${PN} += "${MATRIX_BASE_DIR}/*"

PACKAGES = "matrix-machinevision-demo-dlp3dscanner \
            matrix-machinevision-demo-barcoderoi \
            matrix-machinevision-demo-barcoderoi-f2f \
            matrix-machinevision-demo-simplepeopletracking \
"

RDEPENDS:matrix-machinevision-demo-dlp3dscanner = " \
    ${MACHINEVISION_RDEPENDS} \
"

RDEPENDS:matrix-machinevision-demo-dlp3dscanner:append:dra7xx = " \
    ${@['','point-cloud-viewer'][oe.utils.all_distro_features(d, 'opencv', True, False) and bb.utils.contains('MACHINE_FEATURES', 'gpu', True, False, d)]} \
"

RDEPENDS:matrix-machinevision-demo-barcoderoi = " \
    ${MACHINEVISION_RDEPENDS} \
    ${BARCODE_RDEPENDS} \
"

RDEPENDS:matrix-machinevision-demo-barcoderoi-f2f = " \
    ${MACHINEVISION_RDEPENDS} \
    ${BARCODE_RDEPENDS} \
"

RDEPENDS:matrix-machinevision-demo-simplepeopletracking = " \
    ${MACHINEVISION_RDEPENDS} \
"

FILES:matrix-machinevision-demo-dlp3dscanner    = "${MATRIX_APP_DIR}/machinevision_dlp_3d_scanner/*"
FILES:matrix-machinevision-demo-dlp3dscanner   += "${bindir}/runDlp3DScanner.sh"

FILES:matrix-machinevision-demo-barcoderoi    = "${MATRIX_APP_DIR}/machinevision_barcode_roi/*"
FILES:matrix-machinevision-demo-barcoderoi   += "${bindir}/runBarcodeRoi.sh"
FILES:matrix-machinevision-demo-barcoderoi-f2f = "${MATRIX_APP_DIR}/machinevision_barcode_roi_f2f/*"
FILES:matrix-machinevision-demo-barcoderoi-f2f += "${bindir}/runBarcodeRoiSave2File.sh"

FILES:matrix-machinevision-demo-simplepeopletracking   = "${MATRIX_APP_DIR}/machinevision_simple_people_tracking/*"
FILES:matrix-machinevision-demo-simplepeopletracking   += "${bindir}/runSimplePeopleTracking.sh"
