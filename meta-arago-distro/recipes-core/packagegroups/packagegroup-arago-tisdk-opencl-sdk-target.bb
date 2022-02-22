DESCRIPTION = "Task to install headers and libraries of OpenCL/MP and related components"
LICENSE = "MIT"
PR = "r2"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup features_check

REQUIRED_DISTRO_FEATURES = "opencl"

UTILS = " \
    opencl-staticdev \
    ${@oe.utils.all_distro_features(d, 'openmp', 'openmpacc-dev')} \
"

UTILS:append:dra7xx = " \
    ${@oe.utils.all_distro_features(d, 'openmp', 'linalg-dev')} \
"

RDEPENDS:${PN} = "\
    ${UTILS} \
"
