DESCRIPTION = "GStreamer elements to use the multimedia accelerators available on some TI parts"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

require gstreamer1.0-plugins-ti.inc

PR = "${INC_PR}.4"
SRCREV = "b2afa71ef76518ef8d368c6669c94d823e7972ba"

SRC_URI = "git://git.ti.com/glsdk/gst-plugin-ducati.git;protocol=git"
