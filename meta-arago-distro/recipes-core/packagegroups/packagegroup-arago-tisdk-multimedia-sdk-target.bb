DESCRIPTION = "Task to build and install header and libs into sdk"
LICENSE = "MIT"
PR = "r5"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

MULTIMEDIA = ""

MULTIMEDIA_append_dra7xx = " \
    hevc-arm-decoder-dev \
    hevc-arm-decoder-staticdev \
"

RDEPENDS_${PN} = "\
    ${MULTIMEDIA} \
    packagegroup-arago-gst-sdk-target \
"
