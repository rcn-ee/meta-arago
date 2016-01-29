# When configured for fbdev compositor, make it the default
PACKAGECONFIG[fbdev] = "--enable-fbdev-compositor WESTON_NATIVE_BACKEND="fbdev-backend.so",--disable-fbdev-compositor,udev mtdev"
PACKAGECONFIG[kms] = "--enable-drm-compositor,--disable-drm-compositor,drm udev libgbm mtdev"

PR_append = "-arago2"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

RDEPENDS_${PN} += "weston-conf"

SRC_URI += " \
	file://0001-weston1.9.0-Enabling-DRM-backend-with-multiple-displ.patch \
	file://0002-Weston1.9.0-Allow-visual_id-to-be-0.patch \
"
