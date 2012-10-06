DESCRIPTION = "Task to add multimedia related sources into the SDK"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r0"

inherit task
PACKAGE_ARCH = "${MACHINE_ARCH}"

MULTIMEDIA = ""

MULTIMEDIA_append_am37x-evm = " \
    av-examples-src \
"

MULTIMEDIA_append_am3517-evm = " \
    av-examples-src \
"

RDEPENDS_${PN} = "\
    ${MULTIMEDIA} \
"
