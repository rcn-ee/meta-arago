DESCRIPTION = "Task to add multimedia related packages"
LICENSE = "MIT"
PR = "r6"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

MULTIMEDIA = ""

MULTIMEDIA_append_omap3 = " \
    amsdk-av-files \
"

MULTIMEDIA_append_ti33x = " \
    amsdk-av-files \
"

MULTIMEDIA_append_ti43x = " \
    amsdk-av-files \
    dual-camera-demo \
"

MULTIMEDIA_append_omap-a15 = " \
    amsdk-av-files \
"

MULTIMEDIA_append_am37x-evm = " \
    av-examples \
"

MULTIMEDIA_append_am3517-evm = " \
    av-examples \
"

RDEPENDS_${PN} = "\
    packagegroup-arago-gst \
    ${MULTIMEDIA} \
"
