DESCRIPTION = "Task to install crypto sources in SDK"
LICENSE = "MIT"
PR = "r11"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

CRYPTO_RDEPENDS = ""

#CRYPTO_RDEPENDS_append_ti33x = " ti-crypto-examples-source"
#CRYPTO_RDEPENDS_append_ti43x = " ti-crypto-examples-source"
#CRYPTO_RDEPENDS_append_keystone = " ti-crypto-examples-source"

CRYPTO_RDEPENDS_append_ti33x = " cryptodev-module-source"
CRYPTO_RDEPENDS_append_ti43x = " cryptodev-module-source"
CRYPTO_RDEPENDS_append_dra7xx = " cryptodev-module-source"
CRYPTO_RDEPENDS_append_keystone = " cryptodev-module-source"
CRYPTO_RDEPENDS_append_k3 = " cryptodev-module-source"

RDEPENDS_${PN} = "\
    ${CRYPTO_RDEPENDS} \
"
