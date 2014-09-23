DESCRIPTION = "GStreamer elements to use the multimedia accelerators available on some TI parts"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

require gst-plugins-ti.inc

PR = "${INC_PR}.1"
SRCREV = "6ca21aa3ec8b88b051013af503ef6b702d3c5477"

SRC_URI = "git://git.ti.com/glsdk/gst-plugin-ducati.git;protocol=git"
