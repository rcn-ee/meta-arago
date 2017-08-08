MACHINE_KERNEL_PR_append = ".arago1"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

require copy-defconfig.inc

ALLOW_EMPTY_kernel-devicetree = "1"
