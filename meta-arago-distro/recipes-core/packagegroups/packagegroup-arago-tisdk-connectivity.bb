DESCRIPTION = "Task to install wlan and bluetooth packages into the target FS"
LICENSE = "MIT"
PR = "r19"

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
    wlconf \
    wpa-supplicant-wl18xx \
    crda \
    hostap-daemon-wl18xx \
    ti-wifi-utils-wl18xx \
"
# No bluetooth/bluetooth.h

# netperf has non-standard license, needs verifying
#    netperf

# Further breaks to resolve
#    ti-compat-bluetooth

FIRMWARE_AND_DRIVERS = "\
    wl18xx-firmware \
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
    wpa-gui-e \
"

CONNECTIVITY_RDEPENDS = ""

CONNECTIVITY_RDEPENDS_ti33x = "\
    ${WLAN_COMMON} \
    ${BLUETOOTH_STACK} \
    ${DEMO_APPS} \
    ${FIRMWARE_AND_DRIVERS} \
"

RDEPENDS_${PN} = "\
    ${CONNECTIVITY_RDEPENDS} \
"
