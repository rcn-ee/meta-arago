DESCRIPTION = "Task to add Qt embedded related sources into the sdk"
LICENSE = "MIT"
PR = "r3"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

QT_DEMOS = "\
    qt-tstat-src \
    ${@base_conditional('ARAGO_QT_PROVIDER', 'qt4-embedded-gles', 'quick-playground-src', '', d)} \
"

RDEPENDS_${PN} = "\
    ${QT_DEMOS} \
"
