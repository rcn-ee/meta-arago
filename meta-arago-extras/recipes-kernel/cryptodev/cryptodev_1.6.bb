require cryptodev_${PV}.inc

SUMMARY = "Linux Cryptodev KERNEL MODULE"
DESCRIPTION = "The Cryptodev package contains the kernel /dev/crypto module"

RCONFLICTS_${PN} = "ocf-linux"
RREPLACES_${PN} = "ocf-linux"

inherit module

PR = "r1"
