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

# Disable due to missing IPC in 4.1
#    packagegroup-arago-gst-sdk-target

RDEPENDS_${PN} = "\
    ${MULTIMEDIA} \
"
