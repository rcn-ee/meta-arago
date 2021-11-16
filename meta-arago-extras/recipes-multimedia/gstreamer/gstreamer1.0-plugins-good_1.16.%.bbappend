FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGECONFIG_append = " qt5"

SRC_URI += " \
    file://0001-v4l2src-Increase-minimum-num-buffers-by-3.patch \
    file://0002-v4l2src-Use-generic-dmabuf-import-in-v4l2src.patch \
    file://0001-v4l2object-Update-formats-table-to-include-YUV422-mu.patch \
    file://0001-v4l2src-Check-for-drm-memory-support-in-try_import.patch \
    file://0001-qmlglsink-fix-build-on-EGL-platform-without-X11-head.patch \
    file://0001-gst-plugins-good-1.16.3-v4l2h264enc-Add-Extended-con.patch \
    file://0001-Avoiding-Failure-to-allocate-required-memory.patch \
"

PR_append = ".arago3"
