DESCRIPTION = "Task to add multimedia related sources into the SDK"
LICENSE = "MIT"
PR = "r6"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

MULTIMEDIA = ""

MULTIMEDIA_append_am37x-evm = " \
    av-examples-src \
"

MULTIMEDIA_append_am3517-evm = " \
    av-examples-src \
"

MULTIMEDIA_append_ti43x = ""

#Demo doesn't work on 3.14
# ${@base_conditional('QT_PROVIDER', 'qt5', '', 'dual-camera-demo-src image-gallery-src', d)}

RDEPENDS_${PN} = "\
    ${MULTIMEDIA} \
"
