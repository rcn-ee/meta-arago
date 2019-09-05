PR_append = ".arago2"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
      file://0001-v4l2src-Increase-minimum-num-buffers-by-3.patch \
      file://0002-v4l2src-Use-generic-dmabuf-import-in-v4l2src.patch \
      file://0001-v4l2-Sync-kernel-header-with-linuxtv-tree.patch \
      file://0002-v4l2videodec-Add-HEVC-decoder-support.patch \
      file://0001-v4l2object-Update-formats-table-to-include-YUV422-mu.patch \
      "
