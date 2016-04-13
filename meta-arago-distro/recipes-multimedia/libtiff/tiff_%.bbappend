PR_append = "-arago0"

# Remove xz/lzma support to avoid pulling in additional GPLv3 licenses
DEPENDS_remove = "xz"
EXTRA_OECONF += "--disable-lzma"
