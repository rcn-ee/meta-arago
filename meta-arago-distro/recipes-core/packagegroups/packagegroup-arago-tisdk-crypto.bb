DESCRIPTION = "Task to install crypto packages into target FS"
LICENSE = "MIT"
PR = "r13"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

CRYPTO_SUPPORT = "\
    openssl \
    openssl-bin \
    openssl-conf \
    openssl-engines \
    cryptodev-module \
"

RDEPENDS:${PN} = "\
    ${CRYPTO_SUPPORT} \
"
