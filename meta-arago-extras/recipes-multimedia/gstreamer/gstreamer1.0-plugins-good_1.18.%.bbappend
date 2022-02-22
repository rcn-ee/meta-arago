FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PACKAGECONFIG:append = " qt5"

SRC_URI += " \
    file://0001-v4l2src-Increase-minimum-num-buffers-by-3.patch \
    file://0002-v4l2src-Use-generic-dmabuf-import-in-v4l2src.patch \
    file://0001-v4l2object-Update-formats-table-to-include-YUV422-mu.patch \
    file://0001-v4l2src-Check-for-drm-memory-support-in-try_import.patch \
"

PR:append = ".arago3"
