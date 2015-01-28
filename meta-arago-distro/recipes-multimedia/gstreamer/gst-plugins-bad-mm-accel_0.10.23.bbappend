PR_append = "-arago0"

PACKAGECONFIG = "bzip curl faad"

# Disable features that have potential commercial licensing restrictions
EXTRA_OECONF += "\
    --disable-mpeg2enc \
    --disable-acm \
"
