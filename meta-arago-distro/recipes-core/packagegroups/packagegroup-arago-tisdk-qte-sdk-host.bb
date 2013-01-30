DESCRIPTION = "Task to add Qt embedded related sources into the sdk"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r2"

inherit packagegroup
PACKAGE_ARCH = "${MACHINE_ARCH}"

QT_DEMOS = "\
    qt-tstat-src \
    ${@base_conditional('ARAGO_QT_PROVIDER', 'qt4-embedded-gles', 'quick-playground-src', '', d)} \
"

RDEPENDS_${PN} = "\
    ${QT_DEMOS} \
"
