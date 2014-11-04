# Include the base gst-plugins-bad recipe since this recipe is heavily
# derived from that one.
require recipes-multimedia/gstreamer/gst-plugins-good_${PV}.bb

require gstreamer-mm-accel.inc
require gst-plugins-package-mm-accel.inc

DESCRIPTION = "GStreamer good plugins that use multimedia accelerators found \
               on TI devices"

# Set PROVIDES and RPROVIDES values so that the base recipe names can still
# be used and PREFERRED_PROVIDER can be used to pick between them.
PROVIDES += "gst-plugins-good"
RPROVIDES_${PN} += "gst-plugins-good"
RPROVIDES_${PN}-dev += "gst-plugins-good-dev"
RPROVIDES_${PN}-meta += "gst-plugins-good-meta"
RREPLACES_${PN} += "gst-plugins-good"
RREPLACES_${PN}-dev += "gst-plugins-good-dev"
RREPLACES_${PN}-meta += "gst-plugins-good-meta"
RCONFLICTS_${PN} += "gst-plugins-good"
RCONFLICTS_${PN}-dev += "gst-plugins-good-dev"
RCONFLICTS_${PN}-meta += "gst-plugins-good-meta"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "git://git.ti.com/glsdk/gst-plugins-good0-10.git;protocol=git"
SRCREV = "733289614c50ff4e490d5a37ec4af3a540d1dfb9"

# Fix compile errors with recent kernels
SRC_URI_append = " file://0001-v4l2-fix-build-with-recent-kernels-the-v4l2_buffer-i.patch \
                   file://0001-v4l2_calls-define-V4L2_CID_HCENTER-and-V4L2_CID_VCEN.patch"

S = "${WORKDIR}/git"

do_configure_prepend() {
	git submodule init && git submodule update
	autopoint -f
}

FILESPATH .= ":${COREBASE}/meta/recipes-multimedia/gstreamer/gst-plugins-good-${PV}"
