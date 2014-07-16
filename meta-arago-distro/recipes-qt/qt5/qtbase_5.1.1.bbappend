FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://0001-qeglfswindow.cpp.patch \
	file://0002-qeglfswindow.cpp.patch \
"

PR_append = "-arago1"
