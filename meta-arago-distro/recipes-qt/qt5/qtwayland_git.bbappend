FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
PR:append = ".arago2"

SRC_URI += " \
    file://0001-plugins-decorations-bradient-display-window-icon-onl.patch \
    file://0001-examples-fix-wayland-texture-sharing-custom-composit.patch \
"
