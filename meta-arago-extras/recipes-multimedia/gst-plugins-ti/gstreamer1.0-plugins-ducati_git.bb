DESCRIPTION = "GStreamer elements to use the multimedia accelerators available on some TI parts"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

require gstreamer1.0-plugins-ti.inc

PR = "${INC_PR}.25"
SRCREV = "09dc7c9e0064533026fc1f09f762e13a49495dec"

BRANCH ?= "master"

SRC_URI = "git://git.ti.com/glsdk/gst-plugin-ducati.git;protocol=git;branch=${BRANCH} \
          "

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
