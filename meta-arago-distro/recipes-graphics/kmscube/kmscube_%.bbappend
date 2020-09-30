FILESEXTRAPATHS_append := "${THISDIR}/${PN}:"

SRC_URI += " \
file://0001-meson-check-for-gles3-support.patch \
"

PR_append = ".arago1"
