DESCRIPTION = "GStreamer elements to use the Video Processing Engine (VPE) found on some TI devices"

LICENSE = "LGPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

require gstreamer1.0-plugins-ti.inc

inherit features_check

REQUIRED_MACHINE_FEATURES = "mmip"

PR = "${INC_PR}.20"
SRCREV = "b9dba5a8bc7d14d55125abdce04672e3dc30bbdf"

SRC_URI = "git://git.ti.com/glsdk/gst-plugin-vpe.git;protocol=git \
           file://0001-gstvpe-configure.ac-stop-using-export-symbols-regex.patch \
"
