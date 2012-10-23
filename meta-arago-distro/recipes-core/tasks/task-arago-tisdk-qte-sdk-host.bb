DESCRIPTION = "Task to add Qt embedded related sources into the sdk"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r0"

inherit task

QT_DEMOS = "\
    qt-tstat-src \
"

RDEPENDS_${PN} = "\
    ${QT_DEMOS} \
"
