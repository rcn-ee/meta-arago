DESCRIPTION = "Task to add gstreamer and gstreamer plugins"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
COMPATIBLE_MACHINE = "(am335x-evm|am3517-evm|am37x-evm|omap3evm|beagleboard|beaglebone)"
PR = "r0"

inherit task
PACKAGE_ARCH = "${MACHINE_ARCH}"

GSTREAMER = " \
    gstreamer \
    gst-plugins-base \
    gst-plugins-good \
    gst-plugins-bad \
    gst-plugins-base-meta \
    gst-plugins-good-meta \
    gst-plugins-bad-meta \
    "

RDEPENDS_${PN} = "\
    ${GSTREAMER} \
    gst-ffmpeg \
    "
