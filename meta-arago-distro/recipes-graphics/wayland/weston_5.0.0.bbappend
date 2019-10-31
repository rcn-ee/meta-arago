# When configured for fbdev compositor, make it the default
PACKAGECONFIG[fbdev] = "--enable-fbdev-compositor WESTON_NATIVE_BACKEND="fbdev-backend.so",--disable-fbdev-compositor,udev mtdev"
PACKAGECONFIG[kms] = "--enable-drm-compositor,--disable-drm-compositor,drm udev virtual/libgbm mtdev"

PR_append = ".arago35"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

RDEPENDS_${PN} += "weston-conf"

SRC_URI += " \
        file://0002-weston-Allow-visual_id-to-be-0.patch \
        file://0003-weston-Fix-virtual-keyboard-display-issue-for-QT5-ap.patch \
        file://0004-weston-Fix-touch-screen-crash-issue.patch \
        file://0005-weston-drm-fix-dual-display-issue.patch \
        file://0001-protocol-add-weston-debug.xml.patch \
        file://0002-libweston-add-weston_debug-API-and-implementation.patch \
        file://0003-compositor-add-option-to-enable-weston_debug.patch \
        file://0004-clients-add-weston-debug.patch \
        file://0005-compositor-offer-logs-via-weston-debug.patch \
        file://0006-xwm-dump_property-to-use-FILE-internally.patch \
        file://0007-xwm-move-FILE-to-the-callers-of-dump_property.patch \
        file://0008-xwm-convert-WM_DEBUG-into-a-weston-debug-scope.patch \
        file://0009-compositor-protocol-logger.patch \
        file://0010-compositor-Add-weston_layer_mask_is_infinite.patch \
        file://0011-compositor-Add-scene-graph-debug-scope.patch \
        file://0012-compositor-drm-Add-backend-pointer-to-drm_output.patch \
        file://0013-compositor-drm-Add-drm-backend-log-debug-scope.patch \
	file://0001-HACK-composito-drm-undef-HAVE_GBM_MODIFIERS-explicit.patch \
"

INHIBIT_PACKAGE_STRIP = "1"
