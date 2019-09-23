DESCRIPTION = "Task to install sources for additional utilities/demos for SDKs"
LICENSE = "MIT"
PR = "r36"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

UTILS = " \
    am-sysinfo-src \
    arm-benchmarks-src \
    oprofile-example-src \
"

# ti-pru-sw-edma-driver is currently broken
# Add pru and profibus sources for omapl138 devices
#UTILS_append_omapl138 = " \
#    ti-pru-sw-examples-src \
#"

UTILS_append_omap-a15 = " \
    omapconf-src \
    pru-icss-src \
"

UTILS_append_ti33x = " \
    omapconf-src \
    pru-icss-src \
"

UTILS_append_ti43x = " \
    pru-icss-src \
"

UTILS_append_k2g = " \
    pru-icss-src \
"

UTILS_append_k3 = " \
    jailhouse-src \
    ti-sci-fw-src \
    arm-trusted-firmware-src \
"

UTILS_append_j7-evm = " \
    ti-img-encode-decode-src \
    ti-img-rogue-driver-src \
    pru-icss-src \
"

UTILS_append_am65xx = " \
    pru-icss-src \
"

EXTRA_LIBS = ""

EXTRA_LIBS_append_omap-a15 = " \
    cmem-mod-src \
    uio-module-drv-src \
    big-data-ipc-demo-linux-src \
"

#EXTRA_LIBS_append_dra7xx = " \
#    debugss-module-drv-src \
#    gdbserverproxy-module-drv-src \
#"

EXTRA_LIBS_append_ti33x = " \
    uio-module-drv-src \
"

EXTRA_LIBS_append_ti43x = " \
    cmem-mod-src \
    uio-module-drv-src \
"

# Disable ipsecmgr due to libnl and xfrm conflict
#    ipsecmgr-mod-src
# Disable hplib-mod-srv due to K4.14 breakage
#    hplib-mod-src
EXTRA_LIBS_append_keystone = " \
    cmem-mod-src \
    uio-module-drv-src \
"

#EXTRA_LIBS_append_k2hk = " \
#    debugss-module-drv-src \
#    gdbserverproxy-module-drv-src \
#"

#EXTRA_LIBS_append_k2l = " \
#    debugss-module-drv-src \
#    gdbserverproxy-module-drv-src \
#"

#EXTRA_LIBS_append_k2e = " \
#    debugss-module-drv-src \
#    gdbserverproxy-module-drv-src \
#"

EXTRA_PACKAGES = ""

EXTRA_PACKAGES_append_omap-a15 = " \
    pdm-anomaly-detection-src \
"

EXTRA_PACKAGES_append_ti33x = " \
    pdm-anomaly-detection-src \
"

EXTRA_PACKAGES_append_ti43x = " \
    pdm-anomaly-detection-src \
"

EXTRA_PACKAGES_append_am65xx = " \
    pdm-anomaly-detection-src \
"

RDEPENDS_${PN} = "\
    ${UTILS} \
    ${EXTRA_LIBS} \
    ${EXTRA_PACKAGES} \
"
