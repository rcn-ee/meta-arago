DESCRIPTION = "Task to install OpenCL/MP and related components"
LICENSE = "MIT"
PR = "r3"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES =+ "${PN}-extra"

MAIN_PKGS = " \
    opencl-examples \
"

EXTRA_PKGS = " \
    opencl-staticdev \
    opencl-examples-dev \
    openmpacc-examples-dev \
    python-pyopencl \
"

EXTRA_PKGS_append_k2hk = " \
    linalg-examples \
"

EXTRA_PKGS_append_dra7xx = " \
    linalg-examples \
    opencl-examples \
    kaldi \
"

RDEPENDS_${PN} = "\
    ${MAIN_PKGS} \
"

RDEPENDS_${PN}-extra = "\
    ${EXTRA_PKGS} \
"
