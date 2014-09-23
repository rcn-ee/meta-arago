DESCRIPTION = "GStreamer elements to use the Video Processing Engine (VPE) found on some TI devices"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

require gst-plugins-ti.inc

PR = "${INC_PR}.1"
SRCREV = "b14e905feee2470952184f570f97deeb8e88b619"

SRC_URI = "git://git.ti.com/glsdk/gst-plugin-vpe.git;protocol=git"
