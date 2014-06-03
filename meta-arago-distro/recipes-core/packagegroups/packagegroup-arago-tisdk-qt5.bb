DESCRIPTION = "Task to add Qt embedded related packages"
LICENSE = "MIT"
PR = "r0"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

QT_DEMOS = "\
    qtwayland-examples \
    qtwebkit-examples-examples \
    qt-tstat \
"

RDEPENDS_${PN} = "\
    packagegroup-arago-qt5 \
    ${QT_DEMOS} \
"
