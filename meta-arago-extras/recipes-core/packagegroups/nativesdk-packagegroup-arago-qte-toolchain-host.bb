inherit qt-vars

require nativesdk-packagegroup-arago-sdk-host.bb

DESCRIPTION = "Host packages for Qt Embedded SDK"
LICENSE = "MIT"

RDEPENDS_${PN} += "${QT_RDEPENDS_NATIVESDK_TOOLS}"
