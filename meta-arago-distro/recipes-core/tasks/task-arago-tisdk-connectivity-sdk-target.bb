DESCRIPTION = "Task to install wlan and bluetooth headers and libraries into the SDK"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PR = "r0"

inherit task

PACKAGE_ARCH = "${MACHINE_ARCH}"
ALLOW_EMPTY = "1"

# Bluetooth development packages
BLUETOOTH_STACK = "\
    bluez4-dev \
    openobex-dev \
"

CONNECTIVITY_RDEPENDS = ""

CONNECTIVITY_RDEPENDS_am37x-evm = "\
    ${BLUETOOTH_STACK} \
    wpa-supplicant-dev \
"

CONNECTIVITY_RDEPENDS_am180x-evm = "\
    ${BLUETOOTH_STACK} \
    wpa-supplicant-dev \
"

CONNECTIVITY_RDEPENDS_ti33x  = "\
    ${BLUETOOTH_STACK} \
    wpa-supplicant-dev \
"

RDEPENDS_${PN} = "\
    ${CONNECTIVITY_RDEPENDS} \
"
