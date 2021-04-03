DESCRIPTION = "Host packages for Qt Embedded SDK"
PR = "r10"
LICENSE = "MIT"

inherit packagegroup qt-vars nativesdk

RDEPENDS_${PN} = "\
    nativesdk-packagegroup-arago-tisdk-host \
    ${QT_RDEPENDS_NATIVESDK_TOOLS} \
    "
