# Include the base gst-plugins-base recipe since this recipe is heavily
# derived from that one.
require recipes-multimedia/gstreamer/gst-plugins-base_${PV}.bb

require gstreamer-mm-accel.inc
require gst-plugins-package-mm-accel.inc

DESCRIPTION = "GStreamer base plugins that use multimedia accelerators found \
               on TI devices"

# Set PROVIDES and RPROVIDES values so that the base recipe names can still
# be used and PREFERRED_PROVIDER can be used to pick between them.
PROVIDES += "gst-plugins-base"
RPROVIDES_${PN} += "gst-plugins-base"
RPROVIDES_${PN}-dev += "gst-plugins-base-dev"
RPROVIDES_${PN}-meta += "gst-plugins-base-meta"
RREPLACES_${PN} += "gst-plugins-base"
RREPLACES_${PN}-dev += "gst-plugins-base-dev"
RREPLACES_${PN}-meta += "gst-plugins-base-meta"
RCONFLICTS_${PN} += "gst-plugins-base"
RCONFLICTS_${PN}-dev += "gst-plugins-base-dev"
RCONFLICTS_${PN}-meta += "gst-plugins-base-meta"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "gitsm://git.ti.com/glsdk/gst-plugins-base0-10.git;protocol=git"
SRCREV = "3427e885daa749275e07339d3633b83c717aa419"

S = "${WORKDIR}/git"

do_configure_prepend() {
	autopoint -f
}

EXTRA_OECONF +="--disable-ivorbis "

FILESPATH .= ":${COREBASE}/meta/recipes-multimedia/gstreamer/gst-plugins-base-${PV}"
