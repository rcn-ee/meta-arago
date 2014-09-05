PR_append = "-arago4"

module_autoload_cryptodev = "cryptodev-module"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-allow-for-cross-compiling-cryptodev.patch"
