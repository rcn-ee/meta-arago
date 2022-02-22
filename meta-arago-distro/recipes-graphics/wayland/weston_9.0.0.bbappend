FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PR:append = ".arago3"

#        file://0002-weston-Allow-visual_id-to-be-0.patch
SRC_URI += " \
        file://0003-weston-Fix-virtual-keyboard-display-issue-for-QT5-ap.patch \
        file://0004-weston-Fix-touch-screen-crash-issue.patch \
        file://0001-backend-drm-Select-plane-based-on-current-attached-C.patch \
"
