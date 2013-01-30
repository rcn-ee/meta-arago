DESCRIPTION = "Task to add multimedia related packages"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r2"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

MULTIMEDIA = ""

MULTIMEDIA_append_omap3 = " \
    amsdk-av-files \
"

MULTIMEDIA_append_ti33x = " \
    amsdk-av-files \
"

MULTIMEDIA_append_am37x-evm = " \
    av-examples \
"

MULTIMEDIA_append_am3517-evm = " \
    av-examples \
"

RDEPENDS_${PN} = "\
    packagegroup-arago-gst \
    ${MULTIMEDIA} \
"
