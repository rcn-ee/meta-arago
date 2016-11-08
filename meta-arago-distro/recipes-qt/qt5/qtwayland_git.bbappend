FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
PR_append = ".arago0"

SRC_URI += " \
    file://0001-plugins-decorations-bradient-display-window-icon-onl.patch \
"
