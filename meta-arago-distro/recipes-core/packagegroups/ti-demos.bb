SUMMARY = "TI World packagegroup"
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PDM_ANOMALY_PKG = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'pdm-anomaly-detection', '', d)}"

PDM_ANOMALY = ""
PDM_ANOMALY:ti33x = "${PDM_ANOMALY_PKG}"
PDM_ANOMALY:ti43x = "${PDM_ANOMALY_PKG}"
PDM_ANOMALY:omap-a15 = "${PDM_ANOMALY_PKG}"
PDM_ANOMALY:am65xx = "${PDM_ANOMALY_PKG}"

RDEPENDS:${PN} = "\
    ${PDM_ANOMALY} \
"
