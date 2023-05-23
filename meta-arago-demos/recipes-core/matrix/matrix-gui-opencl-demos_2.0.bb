DESCRIPTION = "OpenCL demo descriptions for Matrix v2"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.2"

inherit allarch features_check

REQUIRED_DISTRO_FEATURES = "opencl"

S = "${WORKDIR}/git/opencl_apps"

# Make sure opencl submenu and app images has been installed
OPENCL_RDEPENDS += "matrix-gui-apps-images matrix-gui-submenus-opencl"

FILES:${PN} += "${MATRIX_BASE_DIR}/*"

PACKAGES = "matrix-opencl-demo-dsplibfft  \
            matrix-opencl-demo-vecadd     \
            matrix-opencl-demo-floatcompute \
"

RDEPENDS:matrix-opencl-demo-dsplibfft     = "${OPENCL_RDEPENDS}"
RDEPENDS:matrix-opencl-demo-vecadd        = "${OPENCL_RDEPENDS}"
RDEPENDS:matrix-opencl-demo-floatcompute  = "${OPENCL_RDEPENDS}"

# Split the matrix files by opencl demos
FILES:matrix-opencl-demo-dsplibfft     = "${MATRIX_APP_DIR}/opencl_dsplib_fft/*"
FILES:matrix-opencl-demo-vecadd        = "${MATRIX_APP_DIR}/opencl_vecadd/*"
FILES:matrix-opencl-demo-floatcompute  = "${MATRIX_APP_DIR}/opencl_float_compute/*"


# Split the ${bindir} files by opencl demos
FILES:matrix-opencl-demo-dsplibfft     += "${bindir}/runOclDsplibFFT.sh"
FILES:matrix-opencl-demo-vecadd        += "${bindir}/runOclVecadd.sh"
FILES:matrix-opencl-demo-floatcompute  += "${bindir}/runOclFloatCompute.sh"
