DESCRIPTION = "Task to add Gtk embedded related packages"
LICENSE = "MIT"
PR = "r0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

GTK = "\
    gtk+3 \
"

GTK_DEMOS = "\
    gtk+3-demo \
"

RDEPENDS_${PN} = "\
    ${GTK} \
    ${GTK_DEMOS} \
"
