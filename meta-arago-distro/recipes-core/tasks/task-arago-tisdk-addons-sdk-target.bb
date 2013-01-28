DESCRIPTION = "Task to install headers and libraries related to addons into the SDK"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PR = "r0"

inherit task

PACKAGE_ARCH = "${MACHINE_ARCH}"
ALLOW_EMPTY = "1"

UTILS = ""

UTILS_append_omap3 = " canutils-dev"
UTILS_append_ti33x = " canutils-dev"

RDEPENDS_${PN} = "\
    ${UTILS} \
"
