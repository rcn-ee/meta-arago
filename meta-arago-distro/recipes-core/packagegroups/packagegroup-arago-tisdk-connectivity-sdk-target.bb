DESCRIPTION = "Task to install wlan headers and libraries into the SDK"
LICENSE = "MIT"
PR = "r6"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

CONNECTIVITY_RDEPENDS = ""

CONNECTIVITY_RDEPENDS_ti33x  = "\
    wpa-supplicant-wl18xx-dev \
"

CONNECTIVITY_RDEPENDS_ti43x  = "\
    wpa-supplicant-wl18xx-dev \
"

RDEPENDS_${PN} = "\
    ${CONNECTIVITY_RDEPENDS} \
"
