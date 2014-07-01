# This recipe is not valid when not using accelerated multimedia IP
python __anonymous() {
    features = bb.data.getVar("MACHINE_FEATURES", d, 1)
    if not features:
        return
    if "mmip" not in features:
        raise bb.parse.SkipPackage('gst-plugins-base needs dependencies derived from "mmip" flag in MACHINE_FEATURES')
}

# Include the base gst-plugins-base recipe since this recipe is heavily
# derived from that one.
require recipes-multimedia/gstreamer/gst-plugins-base_${PV}.bb

DESCRIPTION = "GStreamer base plugins that use multimedia accelerators found \
               on TI devices"

# Set PROVIDES and RPROVIDES values so that the base recipe names can still
# be used and PREFERRED_PROVIDER can be used to pick between them.
PROVIDES += "gst-plugins-base"
RPROVIDES_${PN} += "gst-plugins-base"
RPROVIDES_${PN}-dev += "gst-plugins-base-dev"
RPROVIDES_${PN}-meta += "gst-plugins-base-meta"

SRC_URI = "git://git.ti.com/glsdk/gst-plugins-base0-10.git;protocol=git"
SRCREV = "21305017f6095ad6e9b1a8f1006ee5be780b21f8"

S = "${WORKDIR}/git"

do_configure_prepend() {
	git submodule init && git submodule update
	autopoint -f
}

EXTRA_OECONF +="--disable-ivorbis "

FILES_${PN} += "\
                ${libdir}/*.so \
                ${libdir}/gstreamer-0.10/*"

FILESPATH .= ":${COREBASE}/meta/recipes-multimedia/gstreamer/gst-plugins-base-${PV}"
