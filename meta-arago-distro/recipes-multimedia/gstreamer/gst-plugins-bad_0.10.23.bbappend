PR_append = "-arago0"

# Disable rsvg which caused gtk+ to be pulled in
DEPENDS := "${@oe_filter_out('librsvg','${DEPENDS}', d)}"
EXTRA_OECONF += "--disable-rsvg"

# Remove the restriction of which plugins are built. Previously fbdevsink
# was not built which is needed by the gstreamer demos included in the SDK.
EXTRA_OECONF := "${@oe_filter_out('--with-plugins=musicbrainz,wavpack,ivorbis,mpegvideoparse','${EXTRA_OECONF}', d)}"
