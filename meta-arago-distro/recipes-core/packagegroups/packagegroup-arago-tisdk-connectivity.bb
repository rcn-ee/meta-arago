DESCRIPTION = "Task to install wireless packages into the target FS"
LICENSE = "MIT"
PR = "r32"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

# WLAN support packages.
# These are the packages that all platforms use for WLAN support
WLAN_COMMON = "\
    wireless-tools \
    htop \
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
    iptables \
"

# netperf has non-standard license, needs verifying
#    netperf

FIRMWARE_AND_DRIVERS = "\
    ti-compat-wireless-wl18xx \
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

CONNECTIVITY_RDEPENDS = ""

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
