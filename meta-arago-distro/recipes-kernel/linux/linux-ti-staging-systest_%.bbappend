MACHINE_KERNEL_PR:append = ".arago1"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

require copy-defconfig.inc
require docker.inc

ALLOW_EMPTY:kernel-devicetree = "1"
