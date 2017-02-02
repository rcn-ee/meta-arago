FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PR_append = ".arago1"

KERNEL_MODULE_AUTOLOAD += "cryptodev"

SRC_URI += "file://0001-Adjust-to-another-change-in-the-user-page-API.patch"
