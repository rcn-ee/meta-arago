FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
PR_append = ".arago1"

SRC_URI += " \
    file://0001-plugins-decorations-bradient-display-window-icon-onl.patch \
    file://0001-qwindow-compositor-compositor.cpp-fix-display-issue-.patch \
"
