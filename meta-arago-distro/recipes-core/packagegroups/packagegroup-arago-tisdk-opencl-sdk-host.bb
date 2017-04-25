DESCRIPTION = "Task to install sources for OpenCL/MP apps and demos"
LICENSE = "MIT"
PR = "r1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

UTILS = " \
    opencl-examples-src \
    openmpacc-examples-src \
"

UTILS_append_k2hk = " \
    linalg-examples-src \
"

UTILS_append_dra7xx = " \
    linalg-examples-src \
"

RDEPENDS_${PN} = "\
    ${UTILS} \
"
