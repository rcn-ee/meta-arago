PR_append = ".arago1"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://0001-Fix-build-for-Linux-5.11-rc1.patch"

KERNEL_MODULE_AUTOLOAD += "cryptodev"
