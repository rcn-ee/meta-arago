DESCRIPTION = "GStreamer elements to use the multimedia accelerators available on some TI parts"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

require gstreamer1.0-plugins-ti.inc

PR = "${INC_PR}.11"
SRCREV = "be329c73f19f48faec3d2c323532ba1ec1d22395"

BRANCH ?= "master"

SRC_URI = "git://git.ti.com/glsdk/gst-plugin-ducati.git;protocol=git;branch=${BRANCH} \
          "

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
