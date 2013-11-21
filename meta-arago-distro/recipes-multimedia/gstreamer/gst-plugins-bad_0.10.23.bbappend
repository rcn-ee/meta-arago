PR_append = "-arago5"

# look for files in this layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-gstfbdevsink-Fix-depth-value-for-GST_VIDEO_CAPS_RGB_.patch \
            file://0001-sys-fbdevsink-fixing-calculation-of-bytes-per-pixel.patch"

PACKAGECONFIG = "bzip curl faad"

# Disable features that have potential commercial licensing restrictions
EXTRA_OECONF += "\
    --disable-mpeg2enc \
    --disable-acm \
"
