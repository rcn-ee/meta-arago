DESCRIPTION = "Task to build and install header and libs into sdk"
LICENSE = "MIT"
PR = "r4"

inherit packagegroup

MULTIMEDIA = ""

MULTIMEDIA_append_dra7xx = " \
    hevc-arm-decoder-dev \
    hevc-arm-decoder-staticdev \
"

RDEPENDS_${PN} = "\
    packagegroup-arago-gst-sdk-target \
    ${MULTIMEDIA} \
"
