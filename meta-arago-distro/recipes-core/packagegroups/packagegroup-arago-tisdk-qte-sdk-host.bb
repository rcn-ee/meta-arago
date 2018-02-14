DESCRIPTION = "Task to add Qt embedded related sources into the sdk"
LICENSE = "MIT"
PR = "r7"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

QT4_DEMOS = "\
    ${@oe.utils.conditional('ARAGO_QT_PROVIDER', 'qt4-embedded-gles', 'quick-playground-src', '', d)} \
    qt-tstat-src \
"

QT_DEMOS = "\
"
#    qt-tstat-src 

RDEPENDS_${PN} = "\
    ${@oe.utils.conditional('QT_PROVIDER', 'qt5', '', "${QT4_DEMOS}", d)} \
    ${QT_DEMOS} \
"
