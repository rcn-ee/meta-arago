FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = ".arago0"

SRC_URI_append_dra7xx = "file://0001-HACK-TO-get-kexec-up-on-dra7.patch"
