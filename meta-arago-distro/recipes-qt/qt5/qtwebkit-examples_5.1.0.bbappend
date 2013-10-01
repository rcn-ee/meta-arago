FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://examples-build.patch"

PR_append = "-arago0"
