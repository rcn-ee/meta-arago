DESCRIPTION = "Task to add multimedia related sources into the SDK"
LICENSE = "MIT"
PR = "r15"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

MULTIMEDIA = ""

MULTIMEDIA_append_ti43x = " \
    dual-camera-demo-src \
    image-gallery-src \
    barcode-roi-src \
"

MULTIMEDIA_append_ti33x = " barcode-roi-src"

MULTIMEDIA_append_k3 = " barcode-roi-src"

MULTIMEDIA_append_omap-a15 = " \
    dual-camera-demo-src \
    image-gallery-src \
    barcode-roi-src \
"

MULTIMEDIA_append_dra7xx = " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'dsp', 'qt-opencv-opencl-opengl-multithreaded-src', '', d)} \
"

MULTIMEDIA_append_keystone = " barcode-roi-src"

#Demo doesn't work on 3.14
# ${@oe.utils.conditional('QT_PROVIDER', 'qt5', '', 'dual-camera-demo-src image-gallery-src', d)}

RDEPENDS_${PN} = "\
    ${MULTIMEDIA} \
"
