# look for files in this layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = "-arago11"

SRC_URI += " \
	file://inetd \
	file://inetd.conf \
"
