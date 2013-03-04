DESCRIPTION = "Task to add gstreamer and gstreamer plugins"
LICENSE = "MIT"
PR = "r6"

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
    gst-ffmpeg \
    "
