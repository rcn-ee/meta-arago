DESCRIPTION = "GStreamer elements to use the multimedia accelerators available on some TI parts"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

require gst-plugins-ti.inc

PR = "${INC_PR}.2"
SRCREV = "7f3326b81b838fb6c916acd1d6a3090fda12c772"

SRC_URI = "git://git.ti.com/glsdk/gst-plugin-ducati.git;protocol=git"
