DESCRIPTION = "Task to install wlan packages into the target FS"
LICENSE = "MIT"
PR = "r20"

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
"

# netperf has non-standard license, needs verifying
#    netperf

FIRMWARE_AND_DRIVERS = "\
    wl18xx-firmware \
"

DEMO_APPS = "\
    wpa-gui-e \
"

CONNECTIVITY_RDEPENDS = ""

CONNECTIVITY_RDEPENDS_ti33x = "\
    ${WLAN_COMMON} \
    ${DEMO_APPS} \
    ${FIRMWARE_AND_DRIVERS} \
"

RDEPENDS_${PN} = "\
    ${CONNECTIVITY_RDEPENDS} \
"
