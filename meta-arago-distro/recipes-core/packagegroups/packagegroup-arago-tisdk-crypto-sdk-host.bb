DESCRIPTION = "Task to install crypto sources in SDK"
LICENSE = "MIT"
PR = "r11"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

CRYPTO_RDEPENDS = ""

CRYPTO_RDEPENDS:append:ti33x = " cryptodev-module-source"
CRYPTO_RDEPENDS:append:ti43x = " cryptodev-module-source"
CRYPTO_RDEPENDS:append:dra7xx = " cryptodev-module-source"
CRYPTO_RDEPENDS:append:k3 = " cryptodev-module-source"

RDEPENDS:${PN} = "\
    ${CRYPTO_RDEPENDS} \
"
