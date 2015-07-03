DESCRIPTION = "Task to install wlan and bluetooth sources into the SDK"
LICENSE = "MIT"
PR = "r12"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

FIRMWARE_AND_DRIVERS_SRC = "\
"
#    ti-compat-wireless-wl18xx-src 

CONNECTIVITY_RDEPENDS = ""

CONNECTIVITY_RDEPENDS_ti33x = "${FIRMWARE_AND_DRIVERS_SRC}"

CONNECTIVITY_RDEPENDS_ti43x = "${FIRMWARE_AND_DRIVERS_SRC}"

RDEPENDS_${PN} = "\
    ${CONNECTIVITY_RDEPENDS} \
"
