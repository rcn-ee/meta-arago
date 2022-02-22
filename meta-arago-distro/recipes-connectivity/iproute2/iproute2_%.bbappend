PR:append = ".arago6"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
    file://0014-iplink-hsr-prp-add-support-for-vlan-tagged-supervisi.patch \
"
