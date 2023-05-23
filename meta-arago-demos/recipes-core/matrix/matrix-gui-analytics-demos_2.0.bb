DESCRIPTION = "Analytics demo descriptions for Matrix v2"

require recipes-core/matrix/matrix-gui-apps-git.inc

PR = "${INC_PR}.0"

inherit allarch

S = "${WORKDIR}/git/analytics_apps"

# Make sure analytics submenu and app images has been installed
ANALYTICSDEMO_RDEPENDS += "matrix-gui-apps-images matrix-gui-submenus-analytics"

FILES:${PN} += "${MATRIX_BASE_DIR}/*"

PACKAGES = "matrix-analytics-pdm-anomaly-detection \
"

RDEPENDS:matrix-analytics-pdm-anomaly-detection = " \
    bash \
    ${ANALYTICSDEMO_RDEPENDS} \
    pdm-anomaly-detection \
"

FILES:matrix-analytics-pdm-anomaly-detection = "${MATRIX_APP_DIR}/analytics_pdm_anomaly_detection/*"
FILES:matrix-analytics-pdm-anomaly-detection += "${bindir}/runPdmAnomalyDetection.sh"
