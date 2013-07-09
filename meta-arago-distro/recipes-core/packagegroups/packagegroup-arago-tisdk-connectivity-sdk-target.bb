DESCRIPTION = "Task to install wlan and bluetooth headers and libraries into the SDK"
LICENSE = "MIT"
PR = "r3"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

# Bluetooth development packages
BLUETOOTH_STACK = "\
    bluez4-dev \
    openobex-dev \
"

CONNECTIVITY_RDEPENDS = ""

CONNECTIVITY_RDEPENDS_am37x-evm = "\
    ${BLUETOOTH_STACK} \
"

#    wpa-supplicant-dev

CONNECTIVITY_RDEPENDS_am180x-evm = "\
    ${BLUETOOTH_STACK} \
"

#    wpa-supplicant-dev

CONNECTIVITY_RDEPENDS_ti33x  = "\
    ${BLUETOOTH_STACK} \
"

#    wpa-supplicant-dev

RDEPENDS_${PN} = "\
    ${CONNECTIVITY_RDEPENDS} \
"
