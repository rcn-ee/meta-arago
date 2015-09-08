PR_append = "-arago6"

KERNEL_MODULE_AUTOLOAD += "cryptodev"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-allow-for-cross-compiling-cryptodev.patch"
