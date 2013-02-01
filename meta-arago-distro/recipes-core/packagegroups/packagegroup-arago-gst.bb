DESCRIPTION = "Task to add gstreamer and gstreamer plugins"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r4"

inherit packagegroup

GSTREAMER = " \
    gstreamer \
    gst-plugins-base \
    gst-plugins-good \
    gst-plugins-bad \
    gst-plugins-base-meta \
    gst-plugins-good-meta \
    gst-plugins-bad-meta \
"

RDEPENDS_${PN} = "\
    ${GSTREAMER} \
    "

#    gst-ffmpeg
