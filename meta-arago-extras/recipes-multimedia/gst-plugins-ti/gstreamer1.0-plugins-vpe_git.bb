DESCRIPTION = "GStreamer elements to use the Video Processing Engine (VPE) found on some TI devices"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

require gstreamer1.0-plugins-ti.inc

PR = "${INC_PR}.2"
SRCREV = "876d28b2de5fa02d0f5fa836cba7be9a14b819eb"

SRC_URI = "git://git.ti.com/glsdk/gst-plugin-vpe.git;protocol=git"
