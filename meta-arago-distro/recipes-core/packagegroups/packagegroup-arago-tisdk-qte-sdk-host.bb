DESCRIPTION = "Task to add Qt embedded related sources into the sdk"
LICENSE = "MIT"
PR = "r8"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS:${PN} = "\
    qt-tstat-source \
"
