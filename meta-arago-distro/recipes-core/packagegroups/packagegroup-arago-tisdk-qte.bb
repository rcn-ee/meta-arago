DESCRIPTION = "Task to add Qt embedded related packages"
LICENSE = "MIT"
PR = "r4"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

QT_DEMOS = "\
    qt4-embedded-examples \
    qt4-embedded-demos \
    qt-tstat \
    ${@base_conditional('ARAGO_QT_PROVIDER', 'qt4-embedded-gles', 'quick-playground', '', d)} \
"

RDEPENDS_${PN} = "\
    packagegroup-arago-qte \
    ${QT_DEMOS} \
"
