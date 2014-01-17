DESCRIPTION = "Task to install wlan and bluetooth sources into the SDK"
LICENSE = "MIT"
PR = "r7"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

# Further breaks to resolve
#    ti-compat-bluetooth-src

FIRMWARE_AND_DRIVERS_SRC = "\
    bt-firmware-src \
    bt-enable-src \
    wl18xx-firmware-src \
"

CONNECTIVITY_RDEPENDS = ""

CONNECTIVITY_RDEPENDS_ti33x = "${FIRMWARE_AND_DRIVERS_SRC}"

RDEPENDS_${PN} = "\
    ${CONNECTIVITY_RDEPENDS} \
"
