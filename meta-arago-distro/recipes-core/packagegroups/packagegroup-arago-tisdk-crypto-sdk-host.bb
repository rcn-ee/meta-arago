DESCRIPTION = "Task to install crypto sources in SDK"
LICENSE = "MIT"
PR = "r10"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

CRYPTO_RDEPENDS = ""

CRYPTO_RDEPENDS_append_ti33x = " ti-crypto-examples-src"
CRYPTO_RDEPENDS_append_ti43x = " ti-crypto-examples-src"
CRYPTO_RDEPENDS_append_keystone = " ti-crypto-examples-src"

CRYPTO_RDEPENDS_append_ti33x = " cryptodev-module-src"
CRYPTO_RDEPENDS_append_ti43x = " cryptodev-module-src"
CRYPTO_RDEPENDS_append_dra7xx = " cryptodev-module-src"
CRYPTO_RDEPENDS_append_keystone = " cryptodev-module-src"

CRYPTO_RDEPENDS_append_am37x-evm = "\
    ti-ocf-crypto-module-src \
"

CRYPTO_RDEPENDS_append_am3517-evm = "\
    ti-ocf-crypto-module-src \
"
RDEPENDS_${PN} = "\
    ${CRYPTO_RDEPENDS} \
"
