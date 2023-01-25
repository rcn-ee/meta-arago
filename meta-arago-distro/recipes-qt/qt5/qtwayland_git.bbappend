FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
PR:append = ".arago2"

SRC_URI += " \
    file://0001-plugins-decorations-bradient-display-window-icon-onl.patch \
"

SRCREV = "533fff12f7c4beb177b56b766c71b1c7384e6229"

