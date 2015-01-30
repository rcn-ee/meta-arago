# look for files in this layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = "-arago14"

SRC_URI += " \
	file://inetd \
	file://inetd.conf \
"
