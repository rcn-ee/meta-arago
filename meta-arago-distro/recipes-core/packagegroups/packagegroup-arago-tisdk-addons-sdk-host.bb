DESCRIPTION = "Task to install sources for additional utilities/demos for SDKs"
LICENSE = "MIT"
PR = "r36"

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

UTILS_append_k2g = " \
    pru-icss-source \
"

UTILS_append_k3 = " \
    jailhouse-source \
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

# Disable ipsecmgr due to libnl and xfrm conflict
#    ipsecmgr-mod-source
# Disable hplib-mod-srv due to K4.14 breakage
#    hplib-mod-source
EXTRA_LIBS_append_keystone = " \
    cmem-mod-source \
    uio-module-drv-source \
"

#EXTRA_LIBS_append_k2hk = " \
#    debugss-module-drv-source \
#    gdbserverproxy-module-drv-source \
#"

#EXTRA_LIBS_append_k2l = " \
#    debugss-module-drv-source \
#    gdbserverproxy-module-drv-source \
#"

#EXTRA_LIBS_append_k2e = " \
#    debugss-module-drv-source \
#    gdbserverproxy-module-drv-source \
#"

EXTRA_PACKAGES = ""

EXTRA_PACKAGES_append_omap-a15 = " \
    pdm-anomaly-detection-source \
"

EXTRA_PACKAGES_append_ti33x = " \
    pdm-anomaly-detection-source \
"

EXTRA_PACKAGES_append_ti43x = " \
    pdm-anomaly-detection-source \
"

EXTRA_PACKAGES_append_am65xx = " \
    pdm-anomaly-detection-source \
"

RDEPENDS_${PN} = "\
    ${UTILS} \
    ${EXTRA_LIBS} \
    ${EXTRA_PACKAGES} \
"
