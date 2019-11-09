FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = ".arago0"

SRC_URI += "file://0001-native-state-drm-restrict-udev-enumeration-to-card0-.patch"

