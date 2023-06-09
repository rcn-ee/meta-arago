DESCRIPTION = "Task to install additional scripts and applications into the SDK"
LICENSE = "MIT"
PR = "r30"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

EXTRA_FILES = ""
EXTRA_FILES:ti43x = "tisdk-uenv"
EXTRA_FILES:omap-a15 = "tisdk-readme tisdk-uenv"
EXTRA_FILES:k3 = "tisdk-readme tisdk-uenv"

RDEPENDS:${PN} = "\
    ${EXTRA_FILES} \
"
