SUMMARY = "Task to add multimedia related packages"
LICENSE = "MIT"
PR = "r24"

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
    vis \
    hevc-arm-decoder \
"

MULTIMEDIA_append_omap5-evm = " \
    abefw \
"

ACCEL_MM = ""

ACCEL_MM_append_omap-a15 = " \
    ipumm-fw \
"

ACCEL_MM_append_j7 = " \
    ti-img-encode-decode \
    vxd-dec-fw \
"

RDEPENDS_${PN} = "\
    packagegroup-arago-gst \
    ${MULTIMEDIA} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'mmip', '${ACCEL_MM}', '', d)} \
"
