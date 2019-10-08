require recipes-ti/includes/ti-paths.inc

export LIBARCH_INSTALL_DIR_RECIPE    = "${installdir}/ti-libarch-tree"
export LINALG_INSTALL_DIR_RECIPE     = "${installdir}/ti-linalg-tree"
export LLVM_RTOS_INSTALL_DIR_RECIPE  = "${installdir}/llvm-rtos-tree"
export OCL_RTOS_INSTALL_DIR_RECIPE   = "${installdir}/ti-opencl-rtos-tree"
export OCL_TIDL_FW_INSTALL_DIR_RECIPE   = "${installdir}/ti-opencl-tidl-fw-tree"
export FFTLIB_INSTALL_DIR_RECIPE     = "${installdir}/ti-fftlib-tree"
export FFTW_INSTALL_DIR_RECIPE       = "${installdir}/ti-fftw-tree"
export TIOVX_INSTALL_DIR_RECIPE      = "${installdir}/ti-tiovx-lib-tree"

export LIBARCH_INSTALL_DIR    = "${STAGING_DIR_TARGET}${LIBARCH_INSTALL_DIR_RECIPE}"
export LINALG_INSTALL_DIR     = "${STAGING_DIR_TARGET}${LINALG_INSTALL_DIR_RECIPE}"
export LLVM_RTOS_INSTALL_DIR  = "${STAGING_DIR_TARGET}${LLVM_RTOS_INSTALL_DIR_RECIPE}"
export OCL_RTOS_INSTALL_DIR   = "${STAGING_DIR_TARGET}${OCL_RTOS_INSTALL_DIR_RECIPE}"
export OCL_TIDL_FW_INSTALL_DIR   = "${STAGING_DIR_TARGET}${OCL_TIDL_FW_INSTALL_DIR_RECIPE}"
export FFTLIB_INSTALL_DIR     = "${STAGING_DIR_TARGET}${FFTLIB_INSTALL_DIR_RECIPE}"
export FFTW_INSTALL_DIR       = "${STAGING_DIR_TARGET}${FFTW_INSTALL_DIR_RECIPE}"
export TIOVX_INSTALL_DIR      = "${STAGING_DIR_TARGET}${TIOVX_INSTALL_DIR_RECIPE}"
