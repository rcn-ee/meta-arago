PR_append = "-arago2"

SRCREV = "${AUTOREV}"

UBOOT_LOCALVERSION = "-g${@d.getVar('SRCPV', True).partition('+')[2][0:7]}"
