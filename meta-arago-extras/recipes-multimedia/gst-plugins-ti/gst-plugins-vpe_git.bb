DESCRIPTION = "GStreamer elements to use the Video Processing Engine (VPE) found on some TI devices"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

require gst-plugins-ti.inc

PR = "${INC_PR}.0"
SRCREV = "5107007ca1be8ed66f6a9ec3ffbb70ec7eb0b120"

SRC_URI = "git://git.ti.com/glsdk/gst-plugin-vpe.git;protocol=git"
