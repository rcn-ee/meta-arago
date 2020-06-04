SUMMARY = "TI World packagegroup"
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PDM_ANOMALY = ""
PDM_ANOMALY_ti33x = "pdm-anomaly-detection"
PDM_ANOMALY_ti43x = "pdm-anomaly-detection"
PDM_ANOMALY_omap-a15 = "pdm-anomaly-detection"
PDM_ANOMALY_am65xx = "pdm-anomaly-detection"

RDEPENDS_${PN} = "\
    ${PDM_ANOMALY} \
"
