DESCRIPTION = "Task to install wireless headers and libraries into the SDK"
LICENSE = "MIT"
PR = "r9"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

BLUETOOTH_STACK = "\
    bluez5-dev \
"

CONNECTIVITY_RDEPENDS = ""

CONNECTIVITY_RDEPENDS:ti33x  = "\
    wpa-supplicant-dev \
    ${BLUETOOTH_STACK} \
"

CONNECTIVITY_RDEPENDS:ti43x  = "\
    wpa-supplicant-dev \
    ${BLUETOOTH_STACK} \
"

RDEPENDS:${PN} = "\
    ${CONNECTIVITY_RDEPENDS} \
"
