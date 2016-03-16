require recipes-ti/includes/ti-paths.inc

export LIBARCH_INSTALL_DIR_RECIPE    = "${installdir}/ti-libarch-tree"
export LINALG_INSTALL_DIR_RECIPE     = "${installdir}/ti-linalg-tree"

export LIBARCH_INSTALL_DIR    = "${STAGING_DIR_TARGET}${LIBARCH_INSTALL_DIR_RECIPE}"
export LINALG_INSTALL_DIR     = "${STAGING_DIR_TARGET}${LINALG_INSTALL_DIR_RECIPE}"
