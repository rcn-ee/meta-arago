PR_append = ".arago9"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
    file://runWeston \
"

do_install_append() {
    install -d ${D}${bindir}
    install -m 755 ${WORKDIR}/runWeston ${D}${bindir}
    rm -rf ${D}${systemd_system_unitdir}
}

SYSTEMD_SERVICE_${PN} = ""
