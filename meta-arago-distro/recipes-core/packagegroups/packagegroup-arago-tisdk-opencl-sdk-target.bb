DESCRIPTION = "Task to install headers and libraries of OpenCL/MP and related components"
LICENSE = "MIT"
PR = "r0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

UTILS = " \
    opencl-staticdev \
    openmpacc-dev \
"

UTILS_append_k2hk-evm = " \
    linalg-dev \
"

RDEPENDS_${PN} = "\
    ${UTILS} \
"
