DESCRIPTION = "Task to install crypto packages into target FS"
LICENSE = "MIT"
PR = "r10"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

# Add openssl-misc to get the openssl.cnf file which is
# needed for "openssl req" and to avoid warnings.
# NOTE: This may change to openssl-conf in the future
CRYPTO_SUPPORT = "\
    openssl \
    openssl-misc \
    openssl-engines \
    "

CRYPTO_SUPPORT_append_ti33x = " ti-crypto-examples cryptodev-module cryptodev-tests"
CRYPTO_SUPPORT_append_ti43x = " ti-crypto-examples cryptodev-module cryptodev-tests"
CRYPTO_SUPPORT_append_dra7xx = " ti-crypto-examples cryptodev-module cryptodev-tests"
CRYPTO_SUPPORT_append_keystone = " ti-crypto-examples cryptodev-module cryptodev-tests"

RDEPENDS_${PN} = "\
    ${CRYPTO_SUPPORT} \
    "
