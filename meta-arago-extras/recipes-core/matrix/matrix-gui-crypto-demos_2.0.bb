DESCRIPTION = "Cryptography demo descriptions for Matrix v2"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.12"

PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/git/cryptos_apps_scripts"
S:ti33x = "${WORKDIR}/git/cryptos_apps_program"
S:ti43x = "${WORKDIR}/git/cryptos_apps_program"
S:dra7xx = "${WORKDIR}/git/cryptos_apps_program"

FILES:${PN} += "${MATRIX_BASE_DIR}/*"

# Make sure crypto submenu and app images has been installed. Also make sure openssl is available
RDEPENDS:${PN} += "matrix-gui-apps-images matrix-gui-submenus-cryptos openssl matrix-gui-helper-scripts"
