DESCRIPTION = "GStreamer elements to use the multimedia accelerators available on some TI parts"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

require gstreamer1.0-plugins-ti.inc

PR = "${INC_PR}.24"
SRCREV = "e797c1d832cc8ee1dd66d1683991cb6d7316ed63"

BRANCH ?= "master"

SRC_URI = "git://git.ti.com/glsdk/gst-plugin-ducati.git;protocol=git;branch=${BRANCH} \
          "

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
