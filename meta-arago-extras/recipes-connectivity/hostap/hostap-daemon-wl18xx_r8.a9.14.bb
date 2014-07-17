# This is a TI specific version of the hostap-daemon recipe for use with the
# wl18xx wlan and bluetooth module.

require hostap.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://../COPYING;md5=ab87f20cd7e8c0d0a6539b34d3791d0e"

PR_append = "c+gitr${SRCPV}"

FILESEXTRAPATHS_append := "${THISDIR}/hostap-daemon:"

# Add TI to the end to make it clear that this is a TI customized version
# of hostap
PV = "2.0-devel-ti"

# Tag: ol_r8.a9.14
SRCREV = "281f5adb8eb7ee9e9220546c0227696b02aab332"
BRANCH = "single_hostap_dfs_dynamic"

PROVIDES += "hostap-daemon"
RPROVIDES_${PN} += "hostap-daemon"
RREPLACES_${PN} += "hostap-daemon"
RCONFLICTS_${PN} += "hostap-daemon"
