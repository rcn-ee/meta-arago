DESCRIPTION = "Task to build and install header and libs into sdk"
LICENSE = "MIT"
PR = "r10"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

MULTIMEDIA = ""

MULTIMEDIA_append_dra7xx = " \
    hevc-arm-decoder-dev \
    hevc-arm-decoder-staticdev \
    ${@bb.utils.contains('MACHINE_FEATURES', 'opencl', 'qt-opencv-opencl-opengl-multithreaded-dev', '', d)} \
"

MULTIMEDIA_append_ti33x = " barcode-roi-dev"
MULTIMEDIA_append_ti43x = " barcode-roi-dev"
MULTIMEDIA_append_omap-a15 = " barcode-roi-dev"

MULTIMEDIA_append_keystone = " barcode-roi-dev"

RDEPENDS_${PN} = "\
    ${MULTIMEDIA} \
    packagegroup-arago-gst-sdk-target \
"
