PR_append = "-arago0"

# Remove xz/lzma support to avoid pulling in additional GPLv3 licenses
DEPENDS := "${@oe_filter_out('xz','${DEPENDS}', d)}"
EXTRA_OECONF += " --disable-lzma"

