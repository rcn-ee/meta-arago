PR_append = ".arago0"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
           file://0001-add-support-for-prp-similar-to-hsr.patch \
          "
