DESCRIPTION = "Task to install wireless headers and libraries into the SDK"
LICENSE = "MIT"
PR = "r8"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

BLUETOOTH_STACK = "\
    bluez4-dev \
"

CONNECTIVITY_RDEPENDS = ""

CONNECTIVITY_RDEPENDS_ti33x  = "\
    wpa-supplicant-wl18xx-dev \
    ${BLUETOOTH_STACK} \
"

CONNECTIVITY_RDEPENDS_ti43x  = "\
    wpa-supplicant-wl18xx-dev \
    ${BLUETOOTH_STACK} \
"

RDEPENDS_${PN} = "\
    ${CONNECTIVITY_RDEPENDS} \
"
