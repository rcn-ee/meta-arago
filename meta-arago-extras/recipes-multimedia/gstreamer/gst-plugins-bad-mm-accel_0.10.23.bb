# Include the base gst-plugins-bad recipe since this recipe is heavily
# derived from that one.
require recipes-multimedia/gstreamer/gst-plugins-bad_${PV}.bb

require gstreamer-mm-accel.inc
require gst-plugins-package-mm-accel.inc

DESCRIPTION = "GStreamer bad plugins that use multimedia accelerators found on \
               TI devices"

# Set PROVIDES and RPROVIDES values so that the base recipe names can still
# be used and PREFERRED_PROVIDER can be used to pick between them.
PROVIDES += "gst-plugins-bad"
RPROVIDES_${PN} += "gst-plugins-bad"
RPROVIDES_${PN}-dev += "gst-plugins-bad-dev"
RPROVIDES_${PN}-meta += "gst-plugins-bad-meta"
RREPLACES_${PN} += "gst-plugins-bad"
RREPLACES_${PN}-dev += "gst-plugins-bad-dev"
RREPLACES_${PN}-meta += "gst-plugins-bad-meta"
RCONFLICTS_${PN} += "gst-plugins-bad"
RCONFLICTS_${PN}-dev += "gst-plugins-bad-dev"
RCONFLICTS_${PN}-meta += "gst-plugins-bad-meta"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS += "omap5-sgx-ddk-um-linux libdce libdrm wayland"

SRCREV = "f2df6f3b684f39500e22115b160191cef6d7dbaf"
SRC_URI = "git://git.ti.com/glsdk/gst-plugins-bad0-10.git;protocol=git"

S = "${WORKDIR}/git"

EXTRA_OECONF += " --disable-pvr"

do_configure_prepend() {
	git submodule init && git submodule update
	autopoint -f
}

FILESPATH .= ":${COREBASE}/meta/recipes-multimedia/gstreamer/gst-plugins-bad-${PV}"
