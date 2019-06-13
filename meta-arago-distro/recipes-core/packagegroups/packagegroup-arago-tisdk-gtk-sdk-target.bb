DESCRIPTION = "Task to install Gtk dev packages in SDK"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

RDEPENDS_${PN} = "\
    gtk+3-dev \
"
