DESCRIPTION = "Task to add multimedia related packages"
LICENSE = "MIT"
PR = "r9"

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
    ${@base_conditional('QT_PROVIDER', 'qt5', '', 'dual-camera-demo image-gallery', d)} \
"

MULTIMEDIA_append_omap-a15 = " \
    amsdk-av-files \
"

MULTIMEDIA_append_am37x-evm = " \
    av-examples \
"

MULTIMEDIA_append_omap5-evm = " \
    abefw \
    "

MULTIMEDIA_append_am3517-evm = " \
    av-examples \
"

ACCEL_FW = ""
ACCEL_FW_append_am57xx-evm = " \
    ${@base_contains('MACHINE_FEATURE', 'mmip', 'ipumm-fw', '', d)} \
    "

ACCEL_FW_append_omap5-evm = " \
    ${@base_contains('MACHINE_FEATURE', 'mmip', 'ipumm-fw', '', d)} \
    "

ACCEL_FW_append_dra7xx-evm = " \
    ${@base_contains('MACHINE_FEATURE', 'mmip', 'ipumm-fw', '', d)} \
    dspdce-fw \
    vis \
    "


RDEPENDS_${PN} = "\
    packagegroup-arago-gst \
    ${MULTIMEDIA} \
    ${ACCEL_FW} \
"
