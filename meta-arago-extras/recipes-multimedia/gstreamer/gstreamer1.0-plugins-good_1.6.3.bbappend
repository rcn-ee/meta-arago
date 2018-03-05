PR_append = "_arago_2"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
         file://0001-v4l2src-Increase-minimum-num-buffers-by-4.patch \
      "
