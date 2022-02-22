DESCRIPTION = "Task to build and install header and libs into sdk"
LICENSE = "MIT"
PR = "r12"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

BARCODE_PKG = ""
#BARCODE_PKG = " \
#    ${@['','barcode-roi-dev'][oe.utils.all_distro_features(d, 'opencv', True, False) and bb.utils.contains('MACHINE_FEATURES', 'dsp', True, False, d)]} \
#"

MULTIMEDIA = ""

#    ${@['','qt-opencv-opencl-opengl-multithreaded-dev'][oe.utils.all_distro_features(d, 'opencv opencl opengl', True, False) and bb.utils.contains('MACHINE_FEATURES', 'gpu dsp', True, False, d)]}
MULTIMEDIA_append_dra7xx = " \
    hevc-arm-decoder-dev \
    hevc-arm-decoder-staticdev \
"

MULTIMEDIA_append_ti33x = " ${BARCODE_PKG}"
MULTIMEDIA_append_ti43x = " ${BARCODE_PKG}"
MULTIMEDIA_append_omap-a15 = " ${BARCODE_PKG}"
MULTIMEDIA_append_am65xx = " ${BARCODE_PKG}"

RDEPENDS_${PN} = "\
    ${MULTIMEDIA} \
    packagegroup-arago-gst-sdk-target \
"
