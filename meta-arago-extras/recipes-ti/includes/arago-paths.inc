require recipes-ti/includes/ti-paths.inc

export LIBARCH_INSTALL_DIR_RECIPE    = "${installdir}/ti-libarch-tree"
export LINALG_INSTALL_DIR_RECIPE     = "${installdir}/ti-linalg-tree"
export LLVM_RTOS_INSTALL_DIR_RECIPE  = "${installdir}/llvm-rtos-tree"
export OCL_RTOS_INSTALL_DIR_RECIPE   = "${installdir}/ti-opencl-rtos-tree"

export LIBARCH_INSTALL_DIR    = "${STAGING_DIR_TARGET}${LIBARCH_INSTALL_DIR_RECIPE}"
export LINALG_INSTALL_DIR     = "${STAGING_DIR_TARGET}${LINALG_INSTALL_DIR_RECIPE}"
export LLVM_RTOS_INSTALL_DIR  = "${STAGING_DIR_NATIVE}${LLVM_RTOS_INSTALL_DIR_RECIPE}"
export OCL_RTOS_INSTALL_DIR   = "${STAGING_DIR_TARGET}${OCL_RTOS_INSTALL_DIR_RECIPE}"
