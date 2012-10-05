DESCRIPTION = "Task to install Matrix v2 and associated applications sources in the SDK"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r0"

inherit task

RDEPENDS_${PN} = "\
    matrix-gui-src \
    matrix-gui-browser-src \
    refresh-screen-src \
"
