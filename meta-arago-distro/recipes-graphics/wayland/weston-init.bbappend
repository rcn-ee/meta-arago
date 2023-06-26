FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PR:append = ".arago12"

SRC_URI:append = " \
    file://weston.ini \
    file://weston-launch-calibrator.sh \
    file://weston-socket.sh \
"

do_install:append() {
    install -Dm755 weston-launch-calibrator.sh ${D}/${bindir}/weston-launch-calibrator

    if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)}; then
        install -D -p -m0644 ${WORKDIR}/weston-socket.sh ${D}${sysconfdir}/profile.d/weston-socket.sh
    fi
}

FILES:${PN}:append = "${bindir}/weston-launch-calibrator"

GROUPADD_PARAM:${PN} = "-r wayland; -r render"
USERADD_PARAM:${PN} = "--home /home/weston --shell /bin/sh --user-group -G video,input,render weston"
