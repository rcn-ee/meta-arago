FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PR:append = ".arago1"

#        file://0002-weston-Allow-visual_id-to-be-0.patch
SRC_URI += " \
        file://0003-weston-Fix-virtual-keyboard-display-issue-for-QT5-ap.patch \
        file://0001-backend-drm-Select-plane-based-on-current-attached-C.patch \
        file://0001-Revert-require-GL_EXT_unpack_subimage-commit.patch \
"
