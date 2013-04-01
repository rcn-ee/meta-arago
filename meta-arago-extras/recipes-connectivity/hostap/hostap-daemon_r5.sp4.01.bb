# This is a TI specific version of the hostap-daemon recipe for use with the
# wl12xx wlan and bluetooth module.

require hostap.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://../COPYING;md5=ab87f20cd7e8c0d0a6539b34d3791d0e"

PR_append = "a+gitr${SRCPV}"

SRCREV = "ol_R5.SP4.01"
