DESCRIPTION = "Task to install OpenCL/MP and related components"
LICENSE = "MIT"
PR = "r4"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup features_check

REQUIRED_DISTRO_FEATURES = "opencl"

PACKAGES =+ "${PN}-extra"

MAIN_PKGS = " \
    opencl-examples-offline-compile \
"

EXTRA_PKGS = " \
"

#    ti-fftw-examples
EXTRA_PKGS_append_dra7xx = " \
    ${@oe.utils.all_distro_features(d, 'openmp', 'linalg-examples')} \
"

RDEPENDS_${PN} = "\
    ${MAIN_PKGS} \
"

RDEPENDS_${PN}-extra = "\
    ${EXTRA_PKGS} \
"
