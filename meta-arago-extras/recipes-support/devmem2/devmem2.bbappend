FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
file://0001-devmem.c-ensure-word-is-32-bit-and-add-support-for-6.patch \
"
