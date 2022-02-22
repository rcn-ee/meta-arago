PR:append = ".arago0"

# Remove xz/lzma support to avoid pulling in additional GPLv3 licenses
PACKAGECONFIG:remove = "lzma"
