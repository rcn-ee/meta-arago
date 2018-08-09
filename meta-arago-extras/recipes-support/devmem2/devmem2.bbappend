FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
file://0001-devmem.c-ensure-word-is-32-bit-and-add-support-for-6.patch \
file://0001-devmem2-support-different-page-sizes-at-run-time.patch \
"
