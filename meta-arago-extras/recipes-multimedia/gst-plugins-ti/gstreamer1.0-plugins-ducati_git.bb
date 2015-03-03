DESCRIPTION = "GStreamer elements to use the multimedia accelerators available on some TI parts"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

require gstreamer1.0-plugins-ti.inc

PR = "${INC_PR}.1"
SRCREV = "59fb5be20da72a2f5fb4f25587be668532a90c3b"

SRC_URI = "git://git.ti.com/glsdk/gst-plugin-ducati.git;protocol=git"
