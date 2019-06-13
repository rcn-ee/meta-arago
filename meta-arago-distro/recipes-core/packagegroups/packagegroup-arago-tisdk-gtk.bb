DESCRIPTION = "Task to add Gtk embedded related packages"
LICENSE = "MIT"
PR = "r1"

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
