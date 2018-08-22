DESCRIPTION = "Task to install Gtk dev packages in SDK"
LICENSE = "MIT"
PR = "r0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} = "\
    gtk+3-dev \
"
