DESCRIPTION = "Task to install crypto dev packages in SDK"
LICENSE = "MIT"
PR = "r7"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

CRYPTO_API = ""
CRYPTO_API:ti33x = "cryptodev-module-dev"
CRYPTO_API:ti43x = "cryptodev-module-dev"
CRYPTO_API:dra7xx = "cryptodev-module-dev"

RDEPENDS:${PN} = "\
    openssl-dev \
    ${CRYPTO_API} \
"
