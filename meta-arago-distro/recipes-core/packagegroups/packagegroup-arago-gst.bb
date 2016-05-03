DESCRIPTION = "Task to add gstreamer and gstreamer plugins"
LICENSE = "MIT"
PR = "r16"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

GSTREAMER_DEPS = " \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-base-meta \
    gstreamer1.0-plugins-good-meta \
    gstreamer1.0-plugins-bad-meta \
    gstreamer1.0-libav \
"

GSTREAMER_DEPS_append_dra7xx = " \
    gstreamer1.0-plugins-hevc \
"

GSTREAMER_DEPS_append_keystone = " \
    gstreamer1.0-plugins-hevc \
"

GSTREAMER_ACCEL_MM = ""
GSTREAMER_ACCEL_MM_omap-a15 = "${@bb.utils.contains('MACHINE_FEATURES', 'mmip', "gstreamer1.0-plugins-ducati", '', d)}"
GSTREAMER_ACCEL_MM_append_dra7xx = "${@bb.utils.contains('MACHINE_FEATURES', 'mmip', " gstreamer1.0-plugins-vpe", '', d)}"

RDEPENDS_${PN} = "\
    ${GSTREAMER_DEPS} \
    ${GSTREAMER_ACCEL_MM} \
    "
