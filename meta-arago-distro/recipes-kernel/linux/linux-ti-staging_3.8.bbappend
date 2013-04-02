MACHINE_KERNEL_PR_append = "-arago2"

FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

require copy-defconfig.inc

SRCREV = "${AUTOREV}"
