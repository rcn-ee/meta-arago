FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = ".arago0"

KERNEL_MODULE_AUTOLOAD += "cryptodev"

SRC_URI += "file://0001-ioctl.c-Fix-build-with-linux-4.13.patch"
