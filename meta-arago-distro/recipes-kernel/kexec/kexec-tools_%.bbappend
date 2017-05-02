FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = ".arago1"

SRC_URI += "file://0001-HACK-TO-get-kexec-up-on-dra7.patch"
