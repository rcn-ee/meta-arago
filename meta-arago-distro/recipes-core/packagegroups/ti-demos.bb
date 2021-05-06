SUMMARY = "TI World packagegroup"
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PDM_ANOMALY_PKG = "${@bb.utils.contains('MACHINE_FEATURES', 'gpu', 'pdm-anomaly-detection', '', d)}"

PDM_ANOMALY = ""
PDM_ANOMALY_ti33x = "${PDM_ANOMALY_PKG}"
PDM_ANOMALY_ti43x = "${PDM_ANOMALY_PKG}"
PDM_ANOMALY_omap-a15 = "${PDM_ANOMALY_PKG}"
PDM_ANOMALY_am65xx = "${PDM_ANOMALY_PKG}"

RDEPENDS_${PN} = "\
    ${PDM_ANOMALY} \
"
