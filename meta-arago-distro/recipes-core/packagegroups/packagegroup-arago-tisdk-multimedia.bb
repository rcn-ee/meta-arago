SUMMARY = "Task to add multimedia related packages"
LICENSE = "MIT"
PR = "r24"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

MULTIMEDIA = " \
    amsdk-av-files \
    libcamera \
    libcamera-gst \
"

MULTIMEDIA:omapl138 = ""

DUAL_CAMERA_DEMO = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'dual-camera-demo', '', d)}"
IMAGE_GALLERY_DEMO = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'image-gallery', '', d)}"

MULTIMEDIA:append:ti43x = " \
    ${DUAL_CAMERA_DEMO} \
    ${IMAGE_GALLERY_DEMO} \
"

MULTIMEDIA:append:omap-a15 = " \
    ${DUAL_CAMERA_DEMO} \
    ${IMAGE_GALLERY_DEMO} \
"

MULTIMEDIA:append:dra7xx = " \
    vis \
    hevc-arm-decoder \
"

MULTIMEDIA:append:omap5-evm = " \
    abefw \
"

ACCEL_MM = ""

ACCEL_MM:append:omap-a15 = " \
    ipumm-fw \
"

RDEPENDS:${PN} = "\
    packagegroup-arago-gst \
    ${MULTIMEDIA} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'mmip', '${ACCEL_MM}', '', d)} \
"
