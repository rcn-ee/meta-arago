DESCRIPTION = "Task to install crypto dev packages in SDK"
LICENSE = "MIT"
PR = "r7"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

CRYPTO_API = ""
CRYPTO_API_ti33x = "cryptodev-module-dev"
CRYPTO_API_ti43x = "cryptodev-module-dev"
CRYPTO_API_dra7xx = "cryptodev-module-dev"
CRYPTO_API_keystone = "cryptodev-module-dev"

RDEPENDS_${PN} = "\
    openssl-dev \
    ${CRYPTO_API} \
"
