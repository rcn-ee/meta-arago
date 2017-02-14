DESCRIPTION = "Task to install sources for additional utilities/demos for SDKs"
LICENSE = "MIT"
PR = "r30"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

UTILS = " \
    am-sysinfo-src \
    arm-benchmarks-src \
    oprofile-example-src \
"

# ti-pru-sw-edma-driver is currently broken
# Add pru and profibus sources for omapl138 devices
#UTILS_append_am180x-evm = " \
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

EXTRA_LIBS = ""

# Disable cmem due to 4.9 kernel
#    cmem-mod-src
EXTRA_LIBS_append_omap-a15 = " \
    pru-icss-src \
"

EXTRA_LIBS_append_dra7xx = " \
    debugss-module-drv-src \
    gdbserverproxy-module-drv-src \
"

# Disable ipsecmgr due to libnl and xfrm conflict
#    ipsecmgr-mod-src
# Disable cmem due to 4.9 kernel
#    cmem-mod-src
EXTRA_LIBS_append_keystone = " \
    uio-module-drv-src \
    hplib-mod-src \
"

EXTRA_LIBS_append_k2hk-evm = " \
    debugss-module-drv-src \
    gdbserverproxy-module-drv-src \
"

EXTRA_LIBS_append_k2l-evm = " \
    debugss-module-drv-src \
    gdbserverproxy-module-drv-src \
"

EXTRA_LIBS_append_k2e = " \
    debugss-module-drv-src \
    gdbserverproxy-module-drv-src \
"

RDEPENDS_${PN} = "\
    ${UTILS} \
    ${EXTRA_LIBS} \
"
