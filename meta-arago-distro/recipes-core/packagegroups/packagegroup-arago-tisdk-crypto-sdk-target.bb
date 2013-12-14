DESCRIPTION = "Task to install crypto dev packages in SDK"
LICENSE = "MIT"
PR = "r3"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

CRYPTO_API = "ocf-linux-dev"

CRYPTO_API_ti33x = "cryptodev-dev"
CRYPTO_API_ti43x = "cryptodev-dev"
CRYPTO_API_dra7xx-evm = "cryptodev-dev"

RDEPENDS_${PN} = "\
    openssl-dev \
    ${CRYPTO_API} \
"
