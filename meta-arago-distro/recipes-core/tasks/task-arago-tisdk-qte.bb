DESCRIPTION = "Task to add Qt embedded related packages"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r0"

inherit task

QT_DEMOS = "\
    qt4-embedded-examples \
    qt4-embedded-demos \
    qt-tstat \
"

RDEPENDS_${PN} = "\
    task-arago-qte \
    ${QT_DEMOS} \
"
