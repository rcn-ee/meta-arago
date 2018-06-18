DESCRIPTION = "Task to install Matrix v2 and associated applications sources in the SDK"
LICENSE = "MIT"
PR = "r6"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

MATRIX_GUI = " \
    matrix-gui-browser-src \
    refresh-screen-src \
"

MATRIX_GUI_keystone = ""
MATRIX_GUI_omapl138 = ""
MATRIX_GUI_k3 = ""

RDEPENDS_${PN} = "\
    matrix-gui-src \
    ${MATRIX_GUI} \
"
