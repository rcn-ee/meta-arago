SUMMARY = "Task to install additional miscellaneous packages"
LICENSE = "MIT"
PR = "r0"

inherit packagegroup

RDEPENDS:${PN} = "\
    nano \
    mc \
    rsync \
"
