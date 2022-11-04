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
    ${@['','gstreamer1.0-plugins-dsp66-dev'][oe.utils.all_distro_features(d, 'opencl', True, False) and bb.utils.contains('MACHINE_FEATURES', 'dsp', True, False, d)]} \
"

#    gstreamer1.0-plugins-hevc-dev 
GSTREAMER_DEPS:append:dra7xx = " \
    ${GSTREAMER_DSP} \
"

RDEPENDS:${PN} = " \
    ${GSTREAMER_DEPS} \
"
