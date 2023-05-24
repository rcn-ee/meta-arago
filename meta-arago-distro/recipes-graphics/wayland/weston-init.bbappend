FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PR:append = ".arago12"

SRC_URI:append = " \
    file://weston.ini \
    file://weston-launch-calibrator.sh \
"

do_install:append() {
    install -Dm755 weston-launch-calibrator.sh ${D}/${bindir}/weston-launch-calibrator
}

FILES:${PN}:append = "${bindir}/weston-launch-calibrator"
