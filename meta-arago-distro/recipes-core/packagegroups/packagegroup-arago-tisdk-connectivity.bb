DESCRIPTION = "Task to install wlan and bluetooth packages into the target FS"
LICENSE = "MIT"
PR = "r6"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

# WLAN support packages.
# These are the packages that all platforms use for WLAN support
WLAN_COMMON = "\
    hostap-daemon \
    ti-wifi-utils \
    wireless-tools \
    htop \
    netperf \
    iw \
    crda \
    softap-udhcpd-config \
    oppserver \
    bluez-tools \
    obexd \
    obex-client \
    pulseaudio \
    pulseaudio-server \
    pulseaudio-module-loopback \
    pulseaudio-module-bluetooth-discover \
    pulseaudio-module-bluetooth-device \
    eventdump \
    wpa-supplicant \
"

FIRMWARE_AND_DRIVERS = "\
    ti-compat-wireless-wl12xx \
    ti-compat-bluetooth \
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
    wifi-direct-demo \
    wl1271-demo \
"

# Won't build with new gcc-4.7, need to include <unistd.h>
#    wpa-gui-e
#    battleship

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
    ${FIRMWARE_AND_DRIVERS} \
"

RDEPENDS_${PN} = "\
    ${CONNECTIVITY_RDEPENDS} \
"
