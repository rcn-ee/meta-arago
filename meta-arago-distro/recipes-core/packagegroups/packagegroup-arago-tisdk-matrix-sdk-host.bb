DESCRIPTION = "Task to install Matrix v2 and associated applications sources in the SDK"
LICENSE = "MIT"
PR = "r7"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

MATRIX_GUI = " \
    matrix-gui-browser-src \
    refresh-screen-src \
"

RDEPENDS_${PN} = "\
    matrix-gui-src \
    ${@bb.utils.contains('MACHINE_FEATURES','gpu',"${MATRIX_GUI}",'',d)} \
"
