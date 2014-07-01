# This recipe is not valid when not using accelerated multimedia IP
python __anonymous() {
    features = bb.data.getVar("MACHINE_FEATURES", d, 1)
    if not features:
        return
    if "mmip" not in features:
        raise bb.parse.SkipPackage('gstreamer needs dependencies derived from "mmip" flag in MACHINE_FEATURES')
}

# Include the base gst-plugins-bad recipe since this recipe is heavily
# derived from that one.
require recipes-multimedia/gstreamer/gstreamer_${PV}.bb

DESCRIPTION = "GStreamer that use multimedia accelerators found on TI devices"

# Set PROVIDES and RPROVIDES values so that the base recipe names can still
# be used and PREFERRED_PROVIDER can be used to pick between them.
PROVIDES += "gstreamer"
RPROVIDES_${PN} += "gstreamer"
RPROVIDES_${PN}-dev += "gstreamer-dev"
RPROVIDES_${PN}-meta += "gstreamer-meta"

SRC_URI = "git://git.ti.com/glsdk/gstreamer0-10.git;protocol=git"
SRCREV = "e505f4a2ceee3b0328eb2efddb9ec1281d3fd60a"

S = "${WORKDIR}/git"

do_configure_prepend() {
	git submodule init && git submodule update
	autopoint -f
}

FILESPATH .= ":${COREBASE}/meta/recipes-multimedia/gstreamer/gstreamer-${PV}"
