DESCRIPTION = "Task to build and install header and libs in sdk"
LICENSE = "MIT"
PR = "r15"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

GSTREAMER_DEPS = " \
    gstreamer1.0-dev \
    gstreamer1.0-plugins-base-dev \
    gstreamer1.0-plugins-good-dev \
    gstreamer1.0-plugins-bad-dev \
    gstreamer1.0-libav-dev \
"

GSTREAMER_DSP = " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'dsp', 'gstreamer1.0-plugins-dsp66-dev', '', d)} \
"

GSTREAMER_DEPS_append_dra7xx = " \
    gstreamer1.0-plugins-hevc-dev \
    ${GSTREAMER_DSP} \
"

GSTREAMER_DEPS_append_keystone = " \
    gstreamer1.0-plugins-hevc-dev \
    ${GSTREAMER_DSP} \
"

RDEPENDS_${PN} = " \
    ${GSTREAMER_DEPS} \
"
