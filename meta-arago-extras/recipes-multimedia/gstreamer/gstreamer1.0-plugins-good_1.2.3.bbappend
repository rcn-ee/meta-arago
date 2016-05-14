FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
        file://0001-Adds-GST_V4L2_IO_DMABUF-mode-support-in-capture.patch \
        file://0002-gstv4l2src-Optimize-delay-in-capture.patch"

PR_append = ".arago1"
