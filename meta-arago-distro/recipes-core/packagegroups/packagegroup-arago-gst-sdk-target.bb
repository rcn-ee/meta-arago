DESCRIPTION = "Task to build and install header and libs in sdk"
LICENSE = "MIT"
PR = "r7"

inherit packagegroup

RDEPENDS_${PN} = "\
    gstreamer-dev \
    gst-plugins-base-dev \
    gst-plugins-good-dev \
    gst-plugins-bad-dev \
    gst-ffmpeg-dev \
"
