DESCRIPTION = "GStreamer elements to use the multimedia accelerators available on some TI parts"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

require gst-plugins-ti.inc

PR = "${INC_PR}.0"
SRCREV = "c50cc9132010bde7f4cb9efc04ca3eba536d26f9"

SRC_URI = "git://git.ti.com/glsdk/gst-plugin-ducati.git;protocol=git"
