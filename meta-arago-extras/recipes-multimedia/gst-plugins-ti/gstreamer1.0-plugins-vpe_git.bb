DESCRIPTION = "GStreamer elements to use the Video Processing Engine (VPE) found on some TI devices"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

require gstreamer1.0-plugins-ti.inc

PR = "${INC_PR}.18"
SRCREV = "a1fe1f3e3ae0582a4f84ae8fa7ca052fff2e9f76"

SRC_URI = "git://git.ti.com/glsdk/gst-plugin-vpe.git;protocol=git \
           file://ti-video.conf \
"

do_install_append() {
    install -d ${D}/etc/modprobe.d
    install -m 644 ${WORKDIR}/ti-video.conf ${D}/etc/modprobe.d
}
