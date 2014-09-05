PR_append = "-arago3"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-Fix-touch-with-Weston.patch \
            file://0001-Wayland-correct-touch-location.patch \
            file://0001-Wayland-can-drag-a-window-by-its-titlebar-using-the-.patch \
"


QT_MODULE_BRANCH = "5.4"
