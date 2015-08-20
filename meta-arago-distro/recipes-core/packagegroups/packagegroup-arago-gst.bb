DESCRIPTION = "Task to add gstreamer and gstreamer plugins"
LICENSE = "MIT"
PR = "r14"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

GST_010_DEPS = " \
    gstreamer \
    gst-plugins-base \
    gst-plugins-good \
    gst-plugins-bad \
    gst-plugins-base-meta \
    gst-plugins-good-meta \
    gst-plugins-bad-meta \
    gst-ffmpeg \
"

GST_1X_DEPS = " \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-base-meta \
    gstreamer1.0-plugins-good-meta \
    gstreamer1.0-plugins-bad-meta \
    gstreamer1.0-libav \
"

GST_1X_DEPS_append_dra7xx = " \
    gstreamer1.0-plugins-hevc \
"

GST_PLUGINS_PREFIX = "${@base_conditional('GST_PROVIDER', '0.10', 'gst-plugins', 'gstreamer1.0-plugins', d)}"

GSTREAMER_ACCEL_MM = ""
GSTREAMER_ACCEL_MM_omap-a15 = "${@base_contains('MACHINE_FEATURES', 'mmip', "${GST_PLUGINS_PREFIX}-ducati", '', d)}"
GSTREAMER_ACCEL_MM_append_dra7xx = "${@base_contains('MACHINE_FEATURES', 'mmip', " ${GST_PLUGINS_PREFIX}-vpe", '', d)}"

RDEPENDS_${PN} = "\
    ${@base_conditional('GST_PROVIDER', '0.10', "${GST_010_DEPS}", "${GST_1X_DEPS}", d)} \
    ${GSTREAMER_ACCEL_MM} \
    "
