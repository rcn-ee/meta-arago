DESCRIPTION = "Task to install sources for OpenCL/MP apps and demos"
LICENSE = "MIT"
PR = "r0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

UTILS = " \
    opencl-examples-src \
    openmpacc-examples-src \
"

UTILS_append_k2hk-evm = " \
    linalg-examples-src \
"

RDEPENDS_${PN} = "\
    ${UTILS} \
"
