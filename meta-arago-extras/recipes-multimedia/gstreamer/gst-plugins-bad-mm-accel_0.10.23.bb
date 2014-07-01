# This recipe is not valid when not using accelerated multimedia IP
python __anonymous() {
    features = bb.data.getVar("MACHINE_FEATURES", d, 1)
    if not features:
        return
    if "mmip" not in features:
        raise bb.parse.SkipPackage('gst-plugins-bad needs dependencies derived from "mmip" flag in MACHINE_FEATURES')
}

# Include the base gst-plugins-bad recipe since this recipe is heavily
# derived from that one.
require recipes-multimedia/gstreamer/gst-plugins-bad_${PV}.bb

DESCRIPTION = "GStreamer bad plugins that use multimedia accelerators found on \
               TI devices"

# Set PROVIDES and RPROVIDES values so that the base recipe names can still
# be used and PREFERRED_PROVIDER can be used to pick between them.
PROVIDES += "gst-plugins-bad"
RPROVIDES_${PN} += "gst-plugins-bad"
RPROVIDES_${PN}-dev += "gst-plugins-bad-dev"
RPROVIDES_${PN}-meta += "gst-plugins-bad-meta"

DEPENDS += "omap5-sgx-ddk-um-linux libdce libdrm wayland"

SRCREV = "f2df6f3b684f39500e22115b160191cef6d7dbaf"
SRC_URI = "git://git.ti.com/glsdk/gst-plugins-bad0-10.git;protocol=git"

S = "${WORKDIR}/git"

EXTRA_OECONF += " --disable-pvr"

do_configure_prepend() {
	git submodule init && git submodule update
	autopoint -f
}

FILES_${PN} += "\
                ${libdir}/*.so \
                ${libdir}/gstreamer-0.10/*"

FILESPATH .= ":${COREBASE}/meta/recipes-multimedia/gstreamer/gst-plugins-bad-${PV}"
