DESCRIPTION = "GStreamer elements to use the Video Processing Engine (VPE) found on some TI devices"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

require gstreamer1.0-plugins-ti.inc

PR = "${INC_PR}.8"
SRCREV = "1ba2ca0ae9767290ec09f27f289b66c2c90db3cc"

SRC_URI = "git://git.ti.com/glsdk/gst-plugin-vpe.git;protocol=git \
           file://ti-video.conf \
"

do_install_append() {
    install -d ${D}/etc/modprobe.d
    install -m 644 ${WORKDIR}/ti-video.conf ${D}/etc/modprobe.d
}
