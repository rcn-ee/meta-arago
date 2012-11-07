FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = "-arago0"

SRC_URI_append_virtclass-native += "file://remove_gets.patch"
