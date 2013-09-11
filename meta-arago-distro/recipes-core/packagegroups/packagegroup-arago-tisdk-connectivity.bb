DESCRIPTION = "Task to install wlan and bluetooth packages into the target FS"
LICENSE = "MIT"
PR = "r17"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

# WLAN support packages.
# These are the packages that all platforms use for WLAN support
WLAN_COMMON = "\
    wireless-tools \
    htop \
    iw \
    softap-udhcpd-config \
    bluez-tools \
    obexd \
    obex-client \
    pulseaudio \
    pulseaudio-server \
    pulseaudio-module-loopback \
    pulseaudio-module-bluetooth-discover \
    pulseaudio-module-bluetooth-device \
    eventdump \
    ${@base_contains('WILINK_VERSION','WILINK-8','wlconf','',d)} \
"

# TI/ECS versions of wpa-supplicant/crda/hostap/wifi-utils require older libnl,
# which no longer exists
#    wpa-supplicant
#    crda
#    hostap-daemon
#    ti-wifi-utils
# No bluetooth/bluetooth.h
#    oppserver

# netperf has non-standard license, needs verifying
#    netperf

# Further breaks to resolve
#    ti-compat-wireless-wl12xx
#    ti-compat-bluetooth

FIRMWARE_AND_DRIVERS = "\
    bt-firmware \
    bt-enable \
    wl12xx-firmware \
"

BLUETOOTH_STACK = "\
    bluez4 \
    bluez4-agent \
    libasound-module-bluez \
    bluez-hcidump \
    openobex \
    openobex-apps \
    obexftp \
    ussp-push \
"

DEMO_APPS = "\
    bluetooth-gui \
    wl1271-demo \
"

#    wifi-direct-demo
#    battleship
#    wpa-gui-e

CONNECTIVITY_RDEPENDS = ""

CONNECTIVITY_RDEPENDS_am37x-evm = "\
    ${WLAN_COMMON} \
    ${BLUETOOTH_STACK} \
    ${DEMO_APPS} \
    ${FIRMWARE_AND_DRIVERS} \
"

CONNECTIVITY_RDEPENDS_am180x-evm  = "\
    ${WLAN_COMMON} \
    ${BLUETOOTH_STACK} \
    ${DEMO_APPS} \
    ${FIRMWARE_AND_DRIVERS} \
"

CONNECTIVITY_RDEPENDS_ti33x = "\
    ${WLAN_COMMON} \
    ${BLUETOOTH_STACK} \
    ${DEMO_APPS} \
    ${@base_contains('ARAGO_BRAND','amsdk','${FIRMWARE_AND_DRIVERS}','',d)} \
"

RDEPENDS_${PN} = "\
    ${CONNECTIVITY_RDEPENDS} \
"
