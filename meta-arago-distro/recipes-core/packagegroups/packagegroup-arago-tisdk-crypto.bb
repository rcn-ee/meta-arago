DESCRIPTION = "Task to install crypto packages into target FS"
LICENSE = "MIT"
PR = "r3"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

# Add openssl-misc to get the openssl.cnf file which is
# needed for "openssl req" and to avoid warnings.
# NOTE: This may change to openssl-conf in the future
CRYPTO_SUPPORT = "\
    openssl \
    openssl-misc \
    ti-crypto-examples \
    "

# Add crypto hardware support for am37x-evm
# NOTE: this package depends on a kernel patch which also has a TSU
#       exemption filed.  The current name and checksums of the
#       kernel patch are:
# Name: 0001-linux-omap3-PSP-3.0.1.6-kernel-with-OCF-Linux.patch
# md5sum: 00bb20f2f33a37489d8c52212933368d
# sha256sum: 1fea8323d12cf1ee4f743f0f1c82d7f3821a7d9b7996c44b17d7761579bb090d
CRYPTO_SUPPORT_append_am37x-evm = " ti-ocf-crypto-module"
CRYPTO_SUPPORT_append_am3517-evm = " ti-ocf-crypto-module"

RDEPENDS_${PN} = "\
    ${CRYPTO_SUPPORT} \
    "
