require nativesdk-packagegroup-arago-sdk-host.bb

DESCRIPTION = "Host packages for Qt Embedded SDK"
LICENSE = "MIT"

RDEPENDS_${PN} += "qt4-tools-nativesdk"
