DESCRIPTION = "Task to install crypto dev packages in SDK"
LICENSE = "MIT"
PR = "r8"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

CRYPTO_API = "cryptodev-module-dev"

RDEPENDS:${PN} = "\
    openssl-dev \
    ${CRYPTO_API} \
"
