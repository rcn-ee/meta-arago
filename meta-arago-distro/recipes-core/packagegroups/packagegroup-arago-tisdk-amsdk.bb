DESCRIPTION = "Task to install additional packages only used in the Arago SDK"
LICENSE = "MIT"
PR = "r10"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

# Out of Box Experience (OOBE)
OOBE = ""

OOBE_ti33x += "\
    parse-ip \
"

OOBE_ti43x += "\
    parse-ip \
"

EXTRA_APPLICATIONS = "\
    screenshot \
"

RDEPENDS_${PN} = "\
    ${OOBE} \
    ${EXTRA_APPLICATIONS} \
"
