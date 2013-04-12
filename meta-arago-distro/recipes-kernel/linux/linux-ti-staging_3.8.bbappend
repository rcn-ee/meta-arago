MACHINE_KERNEL_PR_append = "-arago3"

FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

require copy-defconfig.inc

SRCREV = "${AUTOREV}"

KERNEL_LOCALVERSION = "-g${@d.getVar('SRCPV', True).partition('+')[2][0:7]}"
