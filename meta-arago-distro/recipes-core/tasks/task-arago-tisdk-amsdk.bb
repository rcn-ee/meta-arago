DESCRIPTION = "Task to install additional packages only used in the Arago SDK"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r0"

inherit task

PACKAGE_ARCH = "${MACHINE_ARCH}"
ALLOW_EMPTY = "1"

# Out of Box Experience (OOBE)
OOBE = ""

OOBE_ti33x += "\
    gadget-init \
    parse-ip \
"

RDEPENDS_${PN} = "\
    ${OOBE} \
"
