PR_append = ".arago0"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DEPENDS_remove = "virtual/libgl"

SRC_URI += "file://chromium-75.0.3770.80-SIOCGSTAMP.patch"
