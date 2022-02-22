SUMMARY = "Task to add multimedia related sources into the SDK"
LICENSE = "MIT"
PR = "r15"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

BARCODE_PKG = ""
#BARCODE_PKG = " \
#    ${@['','barcode-roi-source'][oe.utils.all_distro_features(d, 'opencv', True, False) and bb.utils.contains('MACHINE_FEATURES', 'dsp', True, False, d)]} \
#"

DUAL_CAMERA_PKG = "${@bb.utils.contains('MACHINE_FEATURES', 'gpu', 'dual-camera-demo-src', '', d)}"
IMAGE_GALLERY_PKG = "${@bb.utils.contains('MACHINE_FEATURES', 'gpu','image-gallery-src', '', d)}"

MULTIMEDIA = ""

MULTIMEDIA_append_ti33x = " ${BARCODE_PKG}"

MULTIMEDIA_append_ti43x = " \
    ${DUAL_CAMERA_PKG} \
    ${IMAGE_GALLERY_PKG} \
    ${BARCODE_PKG} \
"

MULTIMEDIA_append_omap-a15 = " \
    ${DUAL_CAMERA_PKG} \
    ${IMAGE_GALLERY_PKG} \
    ${BARCODE_PKG} \
"

MULTIMEDIA_append_am65xx = " ${BARCODE_PKG}"

#MULTIMEDIA_append_dra7xx = " \
#    ${@['','qt-opencv-opencl-opengl-multithreaded-source'][oe.utils.all_distro_features(d, 'opencv opencl opengl', True, False) and bb.utils.contains('MACHINE_FEATURES', 'gpu dsp', True, False, d)]} \
#"

RDEPENDS_${PN} = "\
    ${MULTIMEDIA} \
"
