DESCRIPTION = "Task to install crypto packages into target FS"
LICENSE = "MIT"
PR = "r11"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

CRYPTO_SUPPORT = "\
    openssl \
    openssl-bin \
    openssl-conf \
    openssl-engines \
"

CRYPTO_SUPPORT_append_ti33x = " ti-crypto-examples cryptodev-module cryptodev-tests"
CRYPTO_SUPPORT_append_ti43x = " ti-crypto-examples cryptodev-module cryptodev-tests"
CRYPTO_SUPPORT_append_dra7xx = " ti-crypto-examples cryptodev-module cryptodev-tests"
CRYPTO_SUPPORT_append_keystone = " ti-crypto-examples cryptodev-module cryptodev-tests"

RDEPENDS_${PN} = "\
    ${CRYPTO_SUPPORT} \
"
