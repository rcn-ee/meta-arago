DESCRIPTION = "Task to build and install header and libs into the sdk"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r3"

inherit packagegroup

RDEPENDS_${PN} = "\
    packagegroup-arago-qte-toolchain-target \
    packagegroup-arago-tisdk-multimedia-sdk-target \
    packagegroup-arago-tisdk-connectivity-sdk-target \
    packagegroup-arago-tisdk-crypto-sdk-target \
    packagegroup-arago-tisdk-graphics-sdk-target \
    packagegroup-arago-tisdk-addons-sdk-target \
"
