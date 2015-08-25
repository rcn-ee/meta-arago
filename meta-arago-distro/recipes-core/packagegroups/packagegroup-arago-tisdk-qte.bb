DESCRIPTION = "Task to add Qt embedded related packages"
LICENSE = "MIT"
PR = "r14"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

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
    qtdeclarative-tools \
    qtlocation-examples \
    qtmultimedia-examples \
    qtscript-examples \
    ${@base_contains('DISTRO_FEATURES', 'wayland', 'qtwayland-examples', '', d)} \
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
