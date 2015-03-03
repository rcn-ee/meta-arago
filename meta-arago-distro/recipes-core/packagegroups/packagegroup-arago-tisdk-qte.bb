DESCRIPTION = "Task to add Qt embedded related packages"
LICENSE = "MIT"
PR = "r10"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

QT4_DEMOS = "\
    qt4-embedded-examples \
    qt4-embedded-demos \
    ${@base_conditional('ARAGO_QT_PROVIDER', 'qt4-embedded-gles', 'quick-playground', '', d)} \
    qt-tstat \
"

QT5_DEMOS = "\
    qt3d-examples \
    qtbase-examples \
    qtdeclarative-examples \
    qtlocation-examples \
    qtmultimedia-examples \
    qtscript-examples \
    qtwayland-examples \
    qtwebkit-examples-examples \
    qtquick1-examples \
"

QT_DEMOS = "\
"
#    qt-tstat 

RDEPENDS_${PN} = "\
    packagegroup-arago-qte \
    ${@base_conditional('QT_PROVIDER', 'qt5', "${QT5_DEMOS}", "${QT4_DEMOS}", d)} \
    ${QT_DEMOS} \
"
