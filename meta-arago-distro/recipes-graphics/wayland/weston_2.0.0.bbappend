# When configured for fbdev compositor, make it the default
PACKAGECONFIG[fbdev] = "--enable-fbdev-compositor WESTON_NATIVE_BACKEND="fbdev-backend.so",--disable-fbdev-compositor,udev mtdev"
PACKAGECONFIG[kms] = "--enable-drm-compositor,--disable-drm-compositor,drm udev libgbm mtdev"

PR_append = ".arago28"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

RDEPENDS_${PN} += "weston-conf"


SRC_URI += " \
	file://0001-udev-seat-restrict-udev-enumeration-to-card0.patch \
        file://0002-weston-Allow-visual_id-to-be-0.patch \
        file://0003-weston-Fix-virtual-keyboard-display-issue-for-QT5-ap.patch \
        file://0004-weston-Fix-touch-screen-crash-issue.patch \
"

INHIBIT_PACKAGE_STRIP = "1"
