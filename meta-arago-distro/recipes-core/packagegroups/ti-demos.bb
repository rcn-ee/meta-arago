SUMMARY = "TI World packagegroup"
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

VOXEL_PKG = ""
#VOXEL_PKG = "${@bb.utils.contains('MACHINE_FEATURES', 'dsp', 'voxelsdk', '', d)}"

VOXELSDK = ""
VOXELSDK_ti33x = "${VOXEL_PKG}"
VOXELSDK_ti43x = "${VOXEL_PKG}"
VOXELSDK_omap-a15 = "${VOXEL_PKG}"

PDM_ANOMALY = ""
PDM_ANOMALY_ti33x = "pdm-anomaly-detection"
PDM_ANOMALY_ti43x = "pdm-anomaly-detection"
PDM_ANOMALY_omap-a15 = "pdm-anomaly-detection"
PDM_ANOMALY_am65xx = "pdm-anomaly-detection"

RDEPENDS_${PN} = "\
    ${VOXELSDK} \
    ${PDM_ANOMALY} \
"
