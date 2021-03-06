FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = ".arago10"

SRC_URI_append = " \
    file://runWeston \
    file://wayland_env.sh \
    file://weston.ini \
"

do_install_append() {
    install -d ${D}${bindir}
    install -m 755 ${WORKDIR}/runWeston ${D}${bindir}

    install -d ${D}${sysconfdir}/profile.d
    install -m 0644 ${WORKDIR}/weston.ini ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/wayland_env.sh ${D}${sysconfdir}/profile.d/
}

FILES_${PN} += "${sysconfdir}/profile.d/* ${sysconfdir}/weston.ini"
