require recipes-ti/includes/ti-paths.inc

export LIBARCH_INSTALL_DIR_RECIPE    = "${installdir}/ti-libarch-tree"

export LIBARCH_INSTALL_DIR    = "${STAGING_DIR_TARGET}${LIBARCH_INSTALL_DIR_RECIPE}"
