MACHINE_KERNEL_PR:append = ".arago5"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

require docker.inc

ALLOW_EMPTY:kernel-devicetree = "1"
