DESCRIPTION = "Task to build and install header and libs in sdk"
LICENSE = "MIT"
PR = "r12"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

GST_010_DEPS = " \
    gstreamer-dev \
    gst-plugins-base-dev \
    gst-plugins-good-dev \
    gst-plugins-bad-dev \
    gst-ffmpeg-dev \
"

GST_1X_DEPS = " \
    gstreamer1.0-dev \
    gstreamer1.0-plugins-base-dev \
    gstreamer1.0-plugins-good-dev \
    gstreamer1.0-plugins-bad-dev \
    gstreamer1.0-libav-dev \
"

GST_1X_DEPS_append_dra7xx = " \
    gstreamer1.0-plugins-hevc-dev \
"

GST_1X_DEPS_append_keystone = " \
    gstreamer1.0-plugins-hevc-dev \
"

RDEPENDS_${PN} = " \
    ${@base_conditional('GST_PROVIDER', '0.10', "${GST_010_DEPS}", "${GST_1X_DEPS}", d)} \
"
