DESCRIPTION = "Task to install headers and libraries of OpenCL/MP and related components"
LICENSE = "MIT"
PR = "r2"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

UTILS = " \
    opencl-staticdev \
    openmpacc-dev \
    python-pyopencl-dev \
"

UTILS_append_k2hk = " \
    linalg-dev \
"

UTILS_append_dra7xx = " \
    linalg-dev \
"

RDEPENDS_${PN} = "\
    ${UTILS} \
"
