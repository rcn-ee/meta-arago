SECTION = "kernel"
DESCRIPTION = "Linux kernel (non-existent) for Arago fake machine"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PV = "2.6"
PR = "r0"

PROVIDES += "virtual/kernel kernel kernel-base kernel-image kernel-dev kernel-vmlinux kernel-misc kernel-modules perf-dbg perf"

INHIBIT_DEFAULT_DEPS = "1"

COMPATIBLE_MACHINE = "arago|arago-armv5|arago-armv7"

PACKAGE_ARCH = "${MACHINE_ARCH}"
