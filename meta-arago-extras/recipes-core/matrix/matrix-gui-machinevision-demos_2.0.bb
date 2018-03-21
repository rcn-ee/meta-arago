DESCRIPTION = "Machine vision demo descriptions for Matrix v2"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"

require recipes-core/matrix/matrix-gui-apps-git.inc

PR = "${INC_PR}.3"

PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/git/machinevision_apps"

# Make sure machinevision submenu and app images has been installed
MACHINEVISION_RDEPENDS += "matrix-gui-apps-images matrix-gui-submenus-machinevision"

FILES_${PN} += "${MATRIX_BASE_DIR}/*"

PACKAGES = "matrix-machinevision-demo-dlp3dscanner \
            matrix-machinevision-demo-barcoderoi \
            matrix-machinevision-demo-barcoderoi-f2f \
            matrix-machinevision-demo-simplepeopletracking \
"

RDEPENDS_matrix-machinevision-demo-dlp3dscanner = " \
    ${MACHINEVISION_RDEPENDS} \
"

RDEPENDS_matrix-machinevision-demo-dlp3dscanner_append_dra7xx = " \
    point-cloud-viewer \
"

RDEPENDS_matrix-machinevision-demo-barcoderoi = " \
    ${MACHINEVISION_RDEPENDS} \
    barcode-roi \
"

RDEPENDS_matrix-machinevision-demo-barcoderoi-f2f = " \
    ${MACHINEVISION_RDEPENDS} \
    barcode-roi \
"

RDEPENDS_matrix-machinevision-demo-simplepeopletracking = " \
    ${MACHINEVISION_RDEPENDS} \
"

FILES_matrix-machinevision-demo-dlp3dscanner    = "${MATRIX_APP_DIR}/machinevision_dlp_3d_scanner/*"
FILES_matrix-machinevision-demo-dlp3dscanner   += "${bindir}/runDlp3DScanner.sh"

FILES_matrix-machinevision-demo-barcoderoi    = "${MATRIX_APP_DIR}/machinevision_barcode_roi/*"
FILES_matrix-machinevision-demo-barcoderoi   += "${bindir}/runBarcodeRoi.sh"
FILES_matrix-machinevision-demo-barcoderoi-f2f = "${MATRIX_APP_DIR}/machinevision_barcode_roi_f2f/*"
FILES_matrix-machinevision-demo-barcoderoi-f2f += "${bindir}/runBarcodeRoiSave2File.sh"

FILES_matrix-machinevision-demo-simplepeopletracking   = "${MATRIX_APP_DIR}/machinevision_simple_people_tracking/*"
FILES_matrix-machinevision-demo-simplepeopletracking   += "${bindir}/runSimplePeopleTracking.sh"
