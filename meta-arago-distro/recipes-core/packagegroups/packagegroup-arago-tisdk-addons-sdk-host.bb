DESCRIPTION = "Task to install sources for additional utilities/demos for SDKs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r1"

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

RDEPENDS_${PN} = "\
    ${UTILS} \
"
