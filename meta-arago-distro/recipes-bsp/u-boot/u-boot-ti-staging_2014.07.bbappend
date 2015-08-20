FILESEXTRAPATHS_append := ":${THISDIR}/${PN}"

PR_append = "-arago7"

UBOOT_LOCALVERSION = "-g${@d.getVar('SRCPV', True).partition('+')[2][0:7]}"
