DESCRIPTION = "Task to install wlan and bluetooth sources into the SDK"
LICENSE = "MIT"
PR = "r10"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

FIRMWARE_AND_DRIVERS_SRC = "\
    wl18xx-firmware-src \
    ti-compat-wireless-wl18xx-src \
"

CONNECTIVITY_RDEPENDS = ""

CONNECTIVITY_RDEPENDS_ti33x = "${FIRMWARE_AND_DRIVERS_SRC}"

CONNECTIVITY_RDEPENDS_ti43x = "${FIRMWARE_AND_DRIVERS_SRC}"

RDEPENDS_${PN} = "\
    ${CONNECTIVITY_RDEPENDS} \
"
