DESCRIPTION = "Task to add multimedia related sources into the SDK"
LICENSE = "MIT"
PR = "r12"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

MULTIMEDIA = ""

MULTIMEDIA_append_ti43x = " \
    dual-camera-demo-src \
    image-gallery-src \
"

MULTIMEDIA_append_dra7xx = " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'opencl', 'qt-opencv-opencl-opengl-multithreaded-src', '', d)} \
"

#Demo doesn't work on 3.14
# ${@base_conditional('QT_PROVIDER', 'qt5', '', 'dual-camera-demo-src image-gallery-src', d)}

RDEPENDS_${PN} = "\
    ${MULTIMEDIA} \
"
