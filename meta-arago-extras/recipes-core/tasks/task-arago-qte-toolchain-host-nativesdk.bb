require task-arago-sdk-host-nativesdk.bb

DESCRIPTION = "Host packages for Qt Embedded SDK"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

RDEPENDS_${PN} += "qt4-tools-nativesdk"
