DESCRIPTION = "Host packages for Qt Embedded SDK"
PR = "r10"
LICENSE = "MIT"

inherit packagegroup nativesdk qt-vars

RDEPENDS_${PN} = "\
    nativesdk-packagegroup-arago-sdk-host \
    ${QT_RDEPENDS_NATIVESDK_TOOLS} \
    "
