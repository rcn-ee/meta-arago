MACHINE_KERNEL_PR_append = "-arago3"

FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

# KVER is used by arago-source-ipk.conf
KVER = "2.6.37"
PSPREL = "03.21.00.04.sdk"

require copy-defconfig.inc
