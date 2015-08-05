DESCRIPTION = "Task to build and install header and libs into sdk"
LICENSE = "MIT"
PR = "r5"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

MULTIMEDIA = ""

MULTIMEDIA_append_dra7xx = " \
    hevc-arm-decoder-dev \
    hevc-arm-decoder-staticdev \
"

RDEPENDS_${PN} = "\
    packagegroup-arago-gst-sdk-target \
    ${MULTIMEDIA} \
"
