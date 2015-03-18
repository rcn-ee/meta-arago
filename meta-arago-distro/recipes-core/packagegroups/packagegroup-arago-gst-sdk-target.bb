DESCRIPTION = "Task to build and install header and libs in sdk"
LICENSE = "MIT"
PR = "r6"

inherit packagegroup

RDEPENDS_${PN} = "\
    gstreamer1.0-dev \
    gstreamer1.0-plugins-base-dev \
    gstreamer1.0-plugins-good-dev \
    gstreamer1.0-plugins-bad-dev \
    gstreamer1.0-libav-dev \
"
