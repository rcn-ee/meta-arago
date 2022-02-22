DESCRIPTION = "Task to install additional packages only used in the Arago SDK"
LICENSE = "MIT"
PR = "r11"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

# Out of Box Experience (OOBE)
OOBE = ""

OOBE:ti33x += "\
    parse-ip \
"

OOBE:ti43x += "\
    parse-ip \
"

RDEPENDS:${PN} = "\
    ${OOBE} \
"
