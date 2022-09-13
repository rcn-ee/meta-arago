FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PR:append = ".arago12"

SRC_URI:append = " \
    file://runWeston \
    file://wayland_env.sh \
    file://weston.ini \
"

do_install:append() {
    install -d ${D}${bindir}
    install -m 755 ${WORKDIR}/runWeston ${D}${bindir}
    rm -rf ${D}${systemd_system_unitdir}

    install -d ${D}${sysconfdir}/profile.d
    install -m 0644 ${WORKDIR}/weston.ini ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/wayland_env.sh ${D}${sysconfdir}/profile.d/
}

FILES:${PN}:remove = "${systemd_system_unitdir}/weston.service ${systemd_system_unitdir}/weston.socket"
FILES:${PN} += "${sysconfdir}/profile.d/* ${sysconfdir}/weston.ini"
SYSTEMD_SERVICE:${PN}:remove = "weston.service weston.socket"
