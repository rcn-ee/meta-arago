# When configured for fbdev compositor, make it the default
PACKAGECONFIG[fbdev] = "--enable-fbdev-compositor WESTON_NATIVE_BACKEND="fbdev-backend.so",--disable-fbdev-compositor,udev mtdev"

PR_append = "-arago1"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://wayland_env.sh"

# Add custom Arago Wayland Environment script file
do_install_append () {
    install -d ${D}${sysconfdir}/profile.d
    install -m 0644 ${WORKDIR}/wayland_env.sh ${D}${sysconfdir}/profile.d/
}

PACKAGES += "${PN}-conf"

FILES_${PN}-conf += "${sysconfdir}/profile.d/*"
RDEPENDS_${PN} += "${PN}-conf"
