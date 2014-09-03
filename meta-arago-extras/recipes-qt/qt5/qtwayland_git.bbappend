PR_append = "-arago2"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-Fix-touch-with-Weston.patch"


QT_MODULE_BRANCH = "5.4"
