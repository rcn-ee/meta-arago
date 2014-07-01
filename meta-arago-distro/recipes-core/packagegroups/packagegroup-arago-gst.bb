DESCRIPTION = "Task to add gstreamer and gstreamer plugins"
LICENSE = "MIT"
PR = "r7"

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

GSTREAMER_ACCEL_MM = ""
GSTREAMER_ACCEL_MM_omap-a15 = "gst-plugins-ducati"
GSTREAMER_ACCEL_MM_append_dra7xx = " gst-plugins-vpe"

RDEPENDS_${PN} = "\
    ${GSTREAMER} \
    ${GSTREAMER_ACCEL_MM} \
    gst-ffmpeg \
    "
