DESCRIPTION = "Task to add gstreamer and gstreamer plugins"
LICENSE = "MIT"
PR = "r10"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

GSTREAMER = " \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-base-meta \
    gstreamer1.0-plugins-good-meta \
    gstreamer1.0-plugins-bad-meta \
"

GSTREAMER_ACCEL_MM = ""
GSTREAMER_ACCEL_MM_omap-a15 = "${@base_contains('MACHINE_FEATURES', 'mmip', 'gstreamer1.0-plugins-ducati', '', d)}"
GSTREAMER_ACCEL_MM_append_dra7xx = "${@base_contains('MACHINE_FEATURES', 'mmip', ' gstreamer1.0-plugins-vpe', '', d)}"

RDEPENDS_${PN} = "\
    ${GSTREAMER} \
    ${GSTREAMER_ACCEL_MM} \
    gstreamer1.0-libav \
    "
