DESCRIPTION = "Task to build and install header and libs in sdk"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r3"

inherit packagegroup

RDEPENDS_${PN} = "\
    gstreamer-dev \
    gst-plugins-base-dev \
    gst-plugins-good-dev \
    gst-plugins-bad-dev \
"
