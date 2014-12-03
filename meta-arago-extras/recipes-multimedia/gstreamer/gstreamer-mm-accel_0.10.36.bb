require gstreamer-mm-accel.inc

# Include the base gst-plugins-bad recipe since this recipe is heavily
# derived from that one.
require recipes-multimedia/gstreamer/gstreamer_${PV}.bb

DESCRIPTION = "GStreamer that use multimedia accelerators found on TI devices"

# Set PROVIDES and RPROVIDES values so that the base recipe names can still
# be used and PREFERRED_PROVIDER can be used to pick between them.
PROVIDES += "gstreamer"
RPROVIDES_${PN} += "gstreamer"
RPROVIDES_${PN}-dev += "gstreamer-dev"
RPROVIDES_${PN}-dbg += "gstreamer-dbg"
RREPLACES_${PN} += "gstreamer"
RREPLACES_${PN}-dev += "gstreamer-dev"
RREPLACES_${PN}-dbg += "gstreamer-dbg"
RCONFLICTS_${PN} += "gstreamer"
RCONFLICTS_${PN}-dev += "gstreamer-dev"
RCONFLICTS_${PN}-dbg += "gstreamer-dbg"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "gitsm://git.ti.com/glsdk/gstreamer0-10.git;protocol=git"
SRCREV = "e505f4a2ceee3b0328eb2efddb9ec1281d3fd60a"

S = "${WORKDIR}/git"

do_configure_prepend() {
	autopoint -f
}

FILESPATH .= ":${COREBASE}/meta/recipes-multimedia/gstreamer/gstreamer-${PV}"
