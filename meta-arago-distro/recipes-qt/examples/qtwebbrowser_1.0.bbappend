FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://0001-qtwebbrowser-disable-FullScreen-mode.patch \
"

PR_append = ".arago0"
