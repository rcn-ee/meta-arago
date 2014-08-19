# When configured for fbdev compositor, make it the default
PACKAGECONFIG[fbdev] = "--enable-fbdev-compositor WESTON_NATIVE_BACKEND="fbdev-backend.so",--disable-fbdev-compositor,udev mtdev"

PR_append = "-arago0"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DEPENDS += "libinput"

SRC_URI += "file://wayland_env.sh \
            file://weston.ini \
"

SRCREV = "e67118c80ad411ac46b7096aae2635510c80ea6d"

EXTRA_OECONF += "--enable-libinput-backend"

# Add custom Arago Wayland Environment script file
do_install_append () {
    install -d ${D}${sysconfdir}/profile.d
    install -m 0644 ${WORKDIR}/weston.ini ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/wayland_env.sh ${D}${sysconfdir}/profile.d/
}

PACKAGES += "${PN}-conf"

FILES_${PN}-conf += "${sysconfdir}/profile.d/* ${sysconfdir}/weston.ini"
RDEPENDS_${PN} += "${PN}-conf"
