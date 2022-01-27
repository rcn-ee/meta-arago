MACHINE_KERNEL_PR_append = ".arago5"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

require copy-defconfig.inc
require docker.inc

ALLOW_EMPTY_kernel-devicetree = "1"
