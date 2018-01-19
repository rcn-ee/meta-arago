PR_append = ".arago0"

# Remove xz/lzma support to avoid pulling in additional GPLv3 licenses
PACKAGECONFIG_remove = "lzma"
