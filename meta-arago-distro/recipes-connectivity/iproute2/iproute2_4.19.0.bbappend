PR_append = ".arago5"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
    file://0001-add-support-for-prp-similar-to-hsr.patch \
    file://0002-hsr-prp-introduce-common-definitions-for-netlink-int.patch \
    file://0003-hsr-prp-refactor-common-code.patch \
    file://0004-hsr-prp-add-support-for-vlan-tagged-supervision-fram.patch \
"
