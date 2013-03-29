DESCRIPTION = "Task to install sources for additional utilities/demos for SDKs"
LICENSE = "MIT"
PR = "r3"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

UTILS = " \
    am-sysinfo-src \
    arm-benchmarks-src \
"

# Add pru and profibus sources for omapl138 devices
UTILS_append_am180x-evm = " \
    ti-pru-sw-examples-src \
"

UTILS_append_omap-a15 = " \
    omapconf-src \
"

RDEPENDS_${PN} = "\
    ${UTILS} \
"
