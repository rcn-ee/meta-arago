PR_append = ".arago6"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGECONFIG_append = " networkd resolved"
USERADD_PARAM_${PN} += "--system -d / -M --shell /bin/nologin systemd-network;"
USERADD_PARAM_${PN} += "--system -d / -M --shell /bin/nologin systemd-resolve;"

SRC_URI_append = " \
    file://local.rules \
    file://usb1-rules.sh \
    file://usb2-rules.sh \
    file://10-eth.network \
    file://15-eth.network \
    file://30-wlan.network \
    file://60-usb.network \
    file://sync-clocks.service \
"

do_install_append() {
    install -d ${D}${sysconfdir}/udev/rules.d/
    install -m 0644 ${WORKDIR}/local.rules ${D}${sysconfdir}/udev/rules.d/

    install -d ${D}${sysconfdir}/udev/scripts/
    install -m 0755 ${WORKDIR}/usb1-rules.sh ${D}${sysconfdir}/udev/scripts/
    install -m 0755 ${WORKDIR}/usb2-rules.sh ${D}${sysconfdir}/udev/scripts/

    install -d ${D}${sysconfdir}/systemd/network/
    install -m 0644 ${WORKDIR}/10-eth.network ${D}${sysconfdir}/systemd/network/
    install -m 0644 ${WORKDIR}/15-eth.network ${D}${sysconfdir}/systemd/network/
    install -m 0644 ${WORKDIR}/30-wlan.network ${D}${sysconfdir}/systemd/network/
    install -m 0644 ${WORKDIR}/60-usb.network ${D}${sysconfdir}/systemd/network/

    install -d ${D}${sysconfdir}/systemd/system/
    install -m 0644 ${WORKDIR}/sync-clocks.service ${D}${sysconfdir}/systemd/system/
    ln -sf ../sync-clocks.service ${D}${sysconfdir}/systemd/system/sysinit.target.wants/sync-clocks.service

    # Allow automount from udev
    install -m 0644 ${D}${systemd_system_unitdir}/systemd-udevd.service ${D}${sysconfdir}/systemd/system/
    sed -i 's/MountFlags=slave/MountFlags=shared/g' ${D}${sysconfdir}/systemd/system/systemd-udevd.service

    # Need NAMESPACES enabled in the kernel, workaround for now
    install -m 0644 ${D}${systemd_system_unitdir}/systemd-hostnamed.service ${D}${sysconfdir}/systemd/system/
    sed -i 's/PrivateNetwork=yes/PrivateNetwork=no/g' ${D}${sysconfdir}/systemd/system/systemd-hostnamed.service
}
