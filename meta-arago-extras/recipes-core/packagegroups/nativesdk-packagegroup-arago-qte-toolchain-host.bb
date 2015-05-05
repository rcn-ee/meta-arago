DESCRIPTION = "Host packages for Qt Embedded SDK"
PR = "r9"
LICENSE = "MIT"

inherit nativesdk packagegroup qt-vars

RDEPENDS_${PN} = "\
    nativesdk-packagegroup-arago-sdk-host \
    ${QT_RDEPENDS_NATIVESDK_TOOLS} \
    "
