DESCRIPTION = "Task to install additional packages only used in the Arago SDK"
LICENSE = "MIT"
PR = "r7"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

# Out of Box Experience (OOBE)
OOBE = ""

OOBE_ti33x += "\
    gadget-init \
    parse-ip \
"

OOBE_ti43x += "\
    gadget-init \
    parse-ip \
"

EXTRA_APPLICATIONS = "\
    screenshot \
"

RDEPENDS_${PN} = "\
    mount-sdcard \
    ${OOBE} \
    ${EXTRA_APPLICATIONS} \
"
