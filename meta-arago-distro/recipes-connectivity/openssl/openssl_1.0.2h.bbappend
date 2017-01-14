FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = ".arago0"

DEPENDS += "cryptodev-linux"
RDEPENDS_${PN}_class-target += "cryptodev-module"

CRYPTODEV_AFALG_PATCHES = " \
	file://0001-cryptodev-Fix-issue-with-signature-generation.patch \
	file://0001-Add-AF_ALG-interface-support-to-OpenSSL.patch \
	file://0004-Sample-AF_ALG-openssl.cnf.patch \
	file://0009-eng_cryptodev-Add-SHA224-initialization-to-cryptodev.patch \
"

SRC_URI += "${CRYPTODEV_AFALG_PATCHES}"
