DESCRIPTION = "Task to add Qt embedded related packages"
LICENSE = "MIT"
PR = "r0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS_${PN} = "\
    qtbase-plugins \
    qtdeclarative-plugins \
    qtlocation-plugins \
    qtmultimedia-plugins \
    qtwayland-plugins \
"
