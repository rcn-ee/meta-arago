DESCRIPTION = "Task to install wlan and bluetooth sources into the SDK"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PR = "r2"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"
ALLOW_EMPTY = "1"

FIRMWARE_AND_DRIVERS_SRC = "\
    ti-compat-wireless-wl12xx-src \
    ti-compat-bluetooth-src \
    bt-firmware-src \
    bt-enable-src \
"

CONNECTIVITY_RDEPENDS = ""

CONNECTIVITY_RDEPENDS_am37x-evm = "${FIRMWARE_AND_DRIVERS_SRC}"
CONNECTIVITY_RDEPENDS_am180x-evm = "${FIRMWARE_AND_DRIVERS_SRC}"
CONNECTIVITY_RDEPENDS_ti33x = "${FIRMWARE_AND_DRIVERS_SRC}"

RDEPENDS_${PN} = "\
    ${CONNECTIVITY_RDEPENDS} \
"
