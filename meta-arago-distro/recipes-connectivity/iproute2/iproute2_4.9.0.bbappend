PR_append = ".arago0"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
           file://0001-ip-HSR-Fix-cut-and-paste-error.patch \
           file://0002-add-support-for-prp-similar-to-hsr.patch \
          "
