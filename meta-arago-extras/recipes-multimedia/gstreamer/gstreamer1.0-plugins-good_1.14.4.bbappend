PR_append = ".arago0"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
      file://0001-v4l2src-Increase-minimum-num-buffers-by-3.patch \
      file://0002-v4l2src-Use-generic-dmabuf-import-in-v4l2src.patch \
      "
