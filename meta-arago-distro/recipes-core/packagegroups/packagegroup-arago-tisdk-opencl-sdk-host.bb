DESCRIPTION = "Task to install sources for OpenCL/MP apps and demos"
LICENSE = "MIT"
PR = "r1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup features_check

REQUIRED_DISTRO_FEATURES = "opencl"

UTILS = " \
    opencl-examples-source \
    ${@oe.utils.all_distro_features(d, 'openmp', 'openmpacc-examples-source')} \
"

UTILS_append_dra7xx = " \
    ${@oe.utils.all_distro_features(d, 'openmp', 'linalg-examples-source')} \
"

RDEPENDS_${PN} = "\
    ${UTILS} \
"
