DESCRIPTION = "Task to install additional packages only used in the Arago SDK"
LICENSE = "MIT"
PR = "r5"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

# Out of Box Experience (OOBE)
OOBE = ""

OOBE_ti33x += "\
    gadget-init \
    parse-ip \
"

# Won't build for hardfp - hardcodes tune flags for armv5te?
#    screenshot

EXTRA_APPLICATIONS = "\
"

RDEPENDS_${PN} = "\
    mount-sdcard \
    ${OOBE} \
    ${EXTRA_APPLICATIONS} \
"
