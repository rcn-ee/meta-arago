DESCRIPTION = "Task to build and install header and libs into the sdk"
LICENSE = "MIT"
PR = "r7"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

QT_TOOLCHAIN_TARGET = "\
    packagegroup-arago-qte-toolchain-target \
"

QT_TOOLCHAIN_TARGET_keystone = ""

RDEPENDS_${PN} = "\
    ${QT_TOOLCHAIN_TARGET} \
    packagegroup-arago-tisdk-multimedia-sdk-target \
    packagegroup-arago-tisdk-connectivity-sdk-target \
    packagegroup-arago-tisdk-crypto-sdk-target \
    ${@base_contains('MACHINE_FEATURES','sgx','packagegroup-arago-tisdk-graphics-sdk-target','',d)} \
    packagegroup-arago-tisdk-addons-sdk-target \
"
