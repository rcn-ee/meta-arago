DESCRIPTION = "Cryptography demo descriptions for Matrix v2"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"
LICENSE = "CC-BY-SA"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.4"

PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/git/cryptos_apps_scripts"
S_ti33x = "${WORKDIR}/git/cryptos_apps_program"

FILES_${PN} += "${MATRIX_BASE_DIR}/*"

# Make sure crypto submenu and app images has been installed. Also make sure openssl is available
RDEPENDS_${PN} += "matrix-gui-apps-images matrix-gui-submenus-cryptos openssl"

RDEPENDS_${PN}_ti33x_append = " ti-crypto-examples"
