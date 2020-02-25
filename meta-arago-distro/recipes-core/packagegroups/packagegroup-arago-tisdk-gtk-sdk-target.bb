DESCRIPTION = "Task to install Gtk dev packages in SDK"
LICENSE = "MIT"
PR = "r2"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup machine_features_check

REQUIRED_MACHINE_FEATURES = "gpu"

RDEPENDS_${PN} = "\
    gtk+3-dev \
"
