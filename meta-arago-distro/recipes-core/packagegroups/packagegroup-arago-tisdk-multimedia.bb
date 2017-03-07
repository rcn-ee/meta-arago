DESCRIPTION = "Task to add multimedia related packages"
LICENSE = "MIT"
PR = "r21"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

MULTIMEDIA = " \
    amsdk-av-files \
"

MULTIMEDIA_omapl138 = ""
MULTIMEDIA_append_keystone = " \
    hevc-arm-decoder \
"

MULTIMEDIA_append_ti43x = " \
    dual-camera-demo \
    image-gallery \
"

MULTIMEDIA_append_omap-a15 = " \
    dual-camera-demo \
    image-gallery \
"

MULTIMEDIA_append_dra7xx = " \
    hevc-arm-decoder \
    ${@bb.utils.contains('MACHINE_FEATURES', 'dsp', 'qt-opencv-opencl-opengl-multithreaded-dev', '', d)} \
"

MULTIMEDIA_append_omap5-evm = " \
    abefw \
"

ACCEL_FW = ""

ACCEL_FW_append_am57xx-evm = " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'mmip', 'ipumm-fw dspdce-fw', '', d)} \
"

ACCEL_FW_append_omap5-evm = " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'mmip', 'ipumm-fw', '', d)} \
"

ACCEL_FW_append_dra7xx-evm = " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'mmip', 'ipumm-fw dspdce-fw', '', d)} \
    vis \
"

RDEPENDS_${PN} = "\
    packagegroup-arago-gst \
    ${MULTIMEDIA} \
    ${ACCEL_FW} \
"
