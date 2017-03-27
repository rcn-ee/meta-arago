FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
    file://0001-playbin-HACK-Change-default-value-of-flags.patch \
"
PR_append = ".arago0"
