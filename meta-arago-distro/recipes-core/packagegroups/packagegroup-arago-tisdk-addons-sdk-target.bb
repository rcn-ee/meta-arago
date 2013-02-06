DESCRIPTION = "Task to install headers and libraries related to addons into the SDK"
LICENSE = "MIT"
PR = "r2"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

UTILS = ""

UTILS_append_omap3 = " canutils-dev"
UTILS_append_ti33x = " canutils-dev"

RDEPENDS_${PN} = "\
    ${UTILS} \
"
