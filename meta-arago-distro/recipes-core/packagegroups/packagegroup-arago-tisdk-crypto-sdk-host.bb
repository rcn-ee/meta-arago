DESCRIPTION = "Task to install crypto sources in SDK"
LICENSE = "MIT"
PR = "r3"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

CRYPTO_RDEPENDS = " \
    ti-crypto-examples-src \
"

CRYPTO_RDEPENDS_append_am37x-evm = "\
    ti-ocf-crypto-module-src \
"

CRYPTO_RDEPENDS_append_am3517-evm = "\
    ti-ocf-crypto-module-src \
"
RDEPENDS_${PN} = "\
    ${CRYPTO_RDEPENDS} \
"
