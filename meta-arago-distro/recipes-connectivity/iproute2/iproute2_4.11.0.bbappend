PR_append = ".arago1"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
           file://0001-add-support-for-prp-similar-to-hsr.patch \
           file://0001-hsr-prp-add-support-for-vlan-tagged-sv-frames.patch \
          "
