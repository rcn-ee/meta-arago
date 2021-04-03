PR_append = ".arago6"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
    file://0014-iplink-hsr-prp-add-support-for-vlan-tagged-supervisi.patch \
"
