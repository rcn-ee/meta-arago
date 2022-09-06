PR_append = ".arago1"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += " \
file://0001-remove-VLA-usage-from-authenc.c.patch \
"

KERNEL_MODULE_AUTOLOAD += "cryptodev"
