FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-configure-expand-path-increase-change-to-2-more-path.patch"

PR_append = "-arago0"
