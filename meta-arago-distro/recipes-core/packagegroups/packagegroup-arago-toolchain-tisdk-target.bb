DESCRIPTION = "Task to build and install header and libs into the sdk"
LICENSE = "MIT"
PR = "r4"

inherit packagegroup

RDEPENDS_${PN} = "\
    packagegroup-arago-qte-toolchain-target \
    packagegroup-arago-tisdk-multimedia-sdk-target \
    packagegroup-arago-tisdk-connectivity-sdk-target \
    packagegroup-arago-tisdk-crypto-sdk-target \
    packagegroup-arago-tisdk-graphics-sdk-target \
    packagegroup-arago-tisdk-addons-sdk-target \
"
