DESCRIPTION = "Task to install wireless packages into the target FS"
LICENSE = "MIT"
PR = "r34"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

# WLAN support packages.
# These are the packages that all platforms use for WLAN support
WLAN_COMMON = "\
    wireless-tools \
    iw \
    softap-udhcpd-config \
    obexd \
    obex-client \
    pulseaudio \
    pulseaudio-server \
    pulseaudio-module-loopback \
    eventdump \
    wlconf \
    wpa-supplicant-wl18xx \
    crda \
    hostap-daemon-wl18xx \
    ti-wifi-utils-wl18xx \
    wl18xx-target-scripts \
"

# netperf has non-standard license, needs verifying
#    netperf

FIRMWARE_AND_DRIVERS = "\
    wl18xx-firmware \
"

DEMO_APPS = "\
    ${@base_conditional('QT_PROVIDER', 'qt5', '', 'wpa-gui-e', d)} \
"

BLUETOOTH_STACK = "\
    bluez4 \
    bluez4-agent \
    bluez-hcidump \
    uim \
"

CONNECTIVITY_RDEPENDS = " \
    htop \
    iptables \
    iproute2 \
    iproute2-tc \
"

CONNECTIVITY_RDEPENDS_ti33x = "\
    ${WLAN_COMMON} \
    ${DEMO_APPS} \
    ${BLUETOOTH_STACK} \
    ${FIRMWARE_AND_DRIVERS} \
    bt-firmware \
"

CONNECTIVITY_RDEPENDS_ti43x = "\
    ${WLAN_COMMON} \
    ${DEMO_APPS} \
    ${BLUETOOTH_STACK} \
    ${FIRMWARE_AND_DRIVERS} \
"

CONNECTIVITY_RDEPENDS_dra7xx = "\
    ${WLAN_COMMON} \
    ${BLUETOOTH_STACK} \
    ${FIRMWARE_AND_DRIVERS} \
    bt-firmware \
"

RDEPENDS_${PN} = "\
    ${CONNECTIVITY_RDEPENDS} \
"
