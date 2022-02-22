FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
PR:append = ".arago1"

DEPENDS += "bison-native"
