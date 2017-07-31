DESCRIPTION = "GStreamer elements to use the multimedia accelerators available on some TI parts"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

require gstreamer1.0-plugins-ti.inc

PR = "${INC_PR}.26"
SRCREV = "c8f6051ac3dff629aa00c22667fcc33cb1cfd074"

BRANCH ?= "master"

SRC_URI = "git://git.ti.com/glsdk/gst-plugin-ducati.git;protocol=git;branch=${BRANCH} \
          "

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
