DESCRIPTION = "Task to add gstreamer and gstreamer plugins"
LICENSE = "MIT"
PR = "r11"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

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
GSTREAMER_ACCEL_MM_omap-a15 = "${@base_contains('MACHINE_FEATURES', 'mmip', 'gst-plugins-ducati', '', d)}"
GSTREAMER_ACCEL_MM_append_dra7xx = "${@base_contains('MACHINE_FEATURES', 'mmip', ' gst-plugins-vpe', '', d)}"

RDEPENDS_${PN} = "\
    ${GSTREAMER} \
    ${GSTREAMER_ACCEL_MM} \
    gst-ffmpeg \
    "
