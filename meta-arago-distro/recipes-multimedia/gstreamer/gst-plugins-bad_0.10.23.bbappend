PR_append = "-arago2"

# look for files in this layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# Disable rsvg which caused gtk+ to be pulled in
DEPENDS := "${@oe_filter_out('librsvg','${DEPENDS}', d)}"
EXTRA_OECONF += "--disable-rsvg"

# Remove the restriction of which plugins are built. Previously fbdevsink
# was not built which is needed by the gstreamer demos included in the SDK.
EXTRA_OECONF := "${@oe_filter_out('--with-plugins=musicbrainz,wavpack,ivorbis,mpegvideoparse','${EXTRA_OECONF}', d)}"

SRC_URI += "file://0001-gstfbdevsink-Fix-depth-value-for-GST_VIDEO_CAPS_RGB_.patch"

# Add faad has a dependency to insure gst-plugins-bad-faad is built.
DEPENDS += "faad2"
RDEPENDS_${PN}-faad += "libfaad"
