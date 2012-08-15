# look for files in this layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://inetd \
	file://inetd.conf \
"

PR_append = "-arago1"
