DESCRIPTION = "Task to install crypto packages into target FS"
LICENSE = "MIT"
PR = "r12"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

CRYPTO_SUPPORT = "\
    openssl \
    openssl-bin \
    openssl-conf \
    openssl-engines \
"

#ti-crypto-examples
CRYPTO_SUPPORT:append:ti33x = " cryptodev-module cryptodev-tests"
CRYPTO_SUPPORT:append:ti43x = " cryptodev-module cryptodev-tests"
CRYPTO_SUPPORT:append:dra7xx = " cryptodev-module cryptodev-tests"

RDEPENDS:${PN} = "\
    ${CRYPTO_SUPPORT} \
"
