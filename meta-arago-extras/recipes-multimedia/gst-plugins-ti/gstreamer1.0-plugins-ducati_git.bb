DESCRIPTION = "GStreamer elements to use the multimedia accelerators available on some TI parts"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

require gstreamer1.0-plugins-ti.inc

PR = "${INC_PR}.30"
SRCREV = "19e911bb45757d8341ffd7819ca783ca04f5e3b1"

BRANCH ?= "master"

SRC_URI = "git://git.ti.com/glsdk/gst-plugin-ducati.git;protocol=git;branch=${BRANCH} \
	   file://0001-gstducati-configure.ac-stop-using-export-symbols-reg.patch \
          "

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
