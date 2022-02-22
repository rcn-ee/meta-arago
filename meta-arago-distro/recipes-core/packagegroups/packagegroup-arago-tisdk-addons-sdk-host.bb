DESCRIPTION = "Task to install sources for additional utilities/demos for SDKs"
LICENSE = "MIT"
PR = "r37"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

UTILS = " \
    am-sysinfo-source \
    arm-benchmarks-source \
    oprofile-example-source \
"

# ti-pru-sw-edma-driver is currently broken
# Add pru and profibus sources for omapl138 devices
#UTILS_append_omapl138 = " \
#    ti-pru-sw-examples-source \
#"

UTILS_append_omap-a15 = " \
    omapconf-source \
    pru-icss-source \
"

UTILS_append_ti33x = " \
    omapconf-source \
    pru-icss-source \
"

UTILS_append_ti43x = " \
    pru-icss-source \
"

UTILS_append_k3 = " \
    ti-sci-fw-source \
    trusted-firmware-a-source \
"

UTILS_append_j7-evm = " \
    pru-icss-source \
"

UTILS_append_j7-hs-evm = " \
    pru-icss-source \
"

UTILS_append_am65xx = " \
    pru-icss-source \
"

UTILS_append_am64xx = " \
    pru-icss-src \
"

EXTRA_LIBS = ""

EXTRA_LIBS_append_omap-a15 = " \
    cmem-mod-source \
    uio-module-drv-source \
    big-data-ipc-demo-linux-source \
"

#EXTRA_LIBS_append_dra7xx = " \
#    debugss-module-drv-source \
#    gdbserverproxy-module-drv-source \
#"

EXTRA_LIBS_append_ti33x = " \
    uio-module-drv-source \
"

EXTRA_LIBS_append_ti43x = " \
    cmem-mod-source \
    uio-module-drv-source \
"

PDM_ANOMALY_PKG_SRC = "\
    ${@bb.utils.contains('MACHINE_FEATURES', 'gpu', 'pdm-anomaly-detection-src', '', d)} \
"

EXTRA_PACKAGES = ""

EXTRA_PACKAGES_append_omap-a15 = " \
    ${PDM_ANOMALY_PKG_SRC} \
"

EXTRA_PACKAGES_append_ti33x = " \
    ${PDM_ANOMALY_PKG_SRC} \
"

EXTRA_PACKAGES_append_ti43x = " \
    ${PDM_ANOMALY_PKG_SRC} \
"

EXTRA_PACKAGES_append_am65xx = " \
    ${PDM_ANOMALY_PKG_SRC} \
"

RDEPENDS_${PN} = "\
    ${UTILS} \
    ${EXTRA_LIBS} \
    ${EXTRA_PACKAGES} \
"
