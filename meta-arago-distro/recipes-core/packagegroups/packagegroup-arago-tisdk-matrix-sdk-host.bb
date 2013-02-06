DESCRIPTION = "Task to install Matrix v2 and associated applications sources in the SDK"
LICENSE = "MIT"
PR = "r2"

inherit packagegroup

RDEPENDS_${PN} = "\
    matrix-gui-src \
    matrix-gui-browser-src \
    refresh-screen-src \
"
