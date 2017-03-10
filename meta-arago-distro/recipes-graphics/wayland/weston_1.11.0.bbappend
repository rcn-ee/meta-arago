# When configured for fbdev compositor, make it the default
PACKAGECONFIG[fbdev] = "--enable-fbdev-compositor WESTON_NATIVE_BACKEND="fbdev-backend.so",--disable-fbdev-compositor,udev mtdev"
PACKAGECONFIG[kms] = "--enable-drm-compositor,--disable-drm-compositor,drm udev libgbm mtdev"

PR_append = ".arago20"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

RDEPENDS_${PN} += "weston-conf"


SRC_URI += " \
	file://0001-udev-seat-restrict-udev-enumeration-to-card0.patch \
	file://0002-Weston-Allow-visual_id-to-be-0.patch \
	file://0003-Weston-Fix-virtual-keyboard-display-issue-for-QT5-ap.patch \
	file://0004-Weston-Fix-touch-screen-crash-issue.patch \
"
