PR:append = ".arago0"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS:remove = "virtual/libgl"

SRC_URI += "file://chromium-75.0.3770.80-SIOCGSTAMP.patch"
SRC_URI += "file://pulse.patch"
