DESCRIPTION = "Task to install Gtk dev packages in SDK"
LICENSE = "MIT"
PR = "r2"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS:${PN} = "\
    gtk+3-dev \
"
