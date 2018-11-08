DESCRIPTION = "Task to install wireless packages into the target FS"
LICENSE = "MIT"
PR = "r41"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

# WLAN support packages.
# These are the packages that all platforms use for WLAN support
WLAN_COMMON = "\
    iw \
    softap-udhcpd-config \
    eventdump \
    wlconf \
    linux-firmware-iwlwifi-8000c \
    linux-firmware-iwlwifi-8265 \
    linux-firmware-iwlwifi-3160-17 \
"

WLAN_TI = "\
    wpa-supplicant-wl18xx \
    hostap-daemon-wl18xx \
    wl18xx-calibrator \
    wl18xx-target-scripts \
    wl18xx-fw \
"

BT_COMMON = "\
    bluez5 \
    bluez5-obex \
    bluez5-noinst-tools \
    bluez5-testtools \
    pulseaudio \
    pulseaudio-server \
    pulseaudio-module-loopback \
    pulseaudio-module-bluetooth-discover \
    pulseaudio-module-bluetooth-policy \
    pulseaudio-module-bluez5-device \
    pulseaudio-module-bluez5-discover \
    pulseaudio-lib-bluez5-util \
    sbc \
"

BT_TI = "\
    uim \
    bt-enable \
    bt-fw \
"

DEMO_APPS = "\
    ${@base_conditional('QT_PROVIDER', 'qt5', '', 'wpa-gui-e', d)} \
"

CONNECTIVITY_RDEPENDS = " \
    htop \
    iptables \
    iproute2 \
    iproute2-tc \
    net-snmp \
"

CONNECTIVITY_RDEPENDS_append_ti33x = "\
    ${WLAN_COMMON} \
    ${WLAN_TI} \
    ${BT_COMMON} \
    ${BT_TI} \
    ${DEMO_APPS} \
"

CONNECTIVITY_RDEPENDS_append_ti43x = "\
    ${WLAN_COMMON} \
    ${WLAN_TI} \
    ${BT_COMMON} \
    ${BT_TI} \
    ${DEMO_APPS} \
"

CONNECTIVITY_RDEPENDS_append_dra7xx = "\
    ${WLAN_COMMON} \
    ${WLAN_TI} \
    ${BT_COMMON} \
    ${BT_TI} \
"

CONNECTIVITY_RDEPENDS_append_k3 = "\
    ${WLAN_COMMON} \
    ${BT_COMMON} \
"

RDEPENDS_${PN} = "\
    ${CONNECTIVITY_RDEPENDS} \
"
