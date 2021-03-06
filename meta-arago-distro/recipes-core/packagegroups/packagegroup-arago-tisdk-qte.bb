DESCRIPTION = "Task to add Qt embedded related packages"
LICENSE = "MIT"
PR = "r22"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup features_check

REQUIRED_MACHINE_FEATURES = "gpu"

QT4_DEMOS = "\
    qt4-embedded-examples \
    qt4-embedded-demos \
    ${@oe.utils.conditional('ARAGO_QT_PROVIDER', 'qt4-embedded-gles', 'quick-playground', '', d)} \
"

#    qtdeclarative-examples
QT5_DEMOS = "\
    qtbase-examples \
    qtdeclarative-tools \
    qtlocation-examples \
    qtmultimedia-examples \
    qtscript-examples \
    qtsvg-examples \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland-examples', '', d)} \
    qtserialport-examples \
    qtcharts-examples \
"

QT_DEMOS = "\
    qt-tstat \
"

RDEPENDS_${PN} = "\
    packagegroup-arago-qte \
    ${@oe.utils.conditional('QT_PROVIDER', 'qt5', "${QT5_DEMOS}", "${QT4_DEMOS}", d)} \
    ${QT_DEMOS} \
"
