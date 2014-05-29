require cryptodev_${PV}.inc

SUMMARY = "Linux Cryptodev KERNEL MODULE"
DESCRIPTION = "The Cryptodev package contains the kernel /dev/crypto module"

RCONFLICTS_${PN} = "ocf-linux"
RREPLACES_${PN} = "ocf-linux"

inherit module

PR = "r2"

SRC_URI += "file://0002-In-the-3.13-rc1-Linux-kernel-the-INIT_COMPLETION-mac.patch"
