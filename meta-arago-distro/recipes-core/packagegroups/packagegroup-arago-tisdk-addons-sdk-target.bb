DESCRIPTION = "Task to install headers and libraries related to addons into the SDK"
LICENSE = "MIT"
PR = "r5"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

UTILS = "libdrm-dev"

UTILS_append_omap3 = " canutils-dev"
UTILS_append_ti33x = " canutils-dev"
UTILS_append_ti43x = " canutils-dev"
UTILS_append_dra7xx = " canutils-dev"

RDEPENDS_${PN} = "\
    ${UTILS} \
"
