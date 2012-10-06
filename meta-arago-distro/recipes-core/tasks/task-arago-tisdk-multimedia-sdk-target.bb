DESCRIPTION = "Task to build and install header and libs into sdk"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r0"

inherit task

RDEPENDS_${PN} = "\
    task-arago-gst-sdk-target \
"
