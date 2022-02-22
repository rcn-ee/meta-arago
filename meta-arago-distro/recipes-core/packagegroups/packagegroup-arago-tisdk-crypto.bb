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
CRYPTO_SUPPORT_append_ti33x = " cryptodev-module cryptodev-tests"
CRYPTO_SUPPORT_append_ti43x = " cryptodev-module cryptodev-tests"
CRYPTO_SUPPORT_append_dra7xx = " cryptodev-module cryptodev-tests"

RDEPENDS_${PN} = "\
    ${CRYPTO_SUPPORT} \
"
