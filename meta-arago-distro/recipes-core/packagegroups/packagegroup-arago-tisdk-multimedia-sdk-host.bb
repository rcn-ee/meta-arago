DESCRIPTION = "Task to add multimedia related sources into the SDK"
LICENSE = "MIT"
PR = "r4"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

MULTIMEDIA = ""

MULTIMEDIA_append_am37x-evm = " \
    av-examples-src \
"

MULTIMEDIA_append_am3517-evm = " \
    av-examples-src \
"

MULTIMEDIA_append_ti43x = " \
    dual-camera-demo-src \
    image-gallery-src \
"

RDEPENDS_${PN} = "\
    ${MULTIMEDIA} \
"
