# This is a TI specific version of the hostap-daemon recipe for use with the
# wl12xx wlan and bluetooth module.

require hostap.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://../COPYING;md5=c54ce9345727175ff66d17b67ff51f58"

PR_append = "a+gitr${SRCPV}"

SRCREV = "ol_R5.00.18"
