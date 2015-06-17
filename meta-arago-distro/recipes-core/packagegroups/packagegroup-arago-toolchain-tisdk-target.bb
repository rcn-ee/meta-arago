DESCRIPTION = "Task to build and install header and libs into the sdk"
LICENSE = "MIT"
PR = "r7"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

QT_TOOLCHAIN_TARGET = "\
    packagegroup-arago-qte-toolchain-target \
"

QT_TOOLCHAIN_TARGET_keystone = ""

TISDK_TOOLCHAIN_BASE_TARGET = "\
    packagegroup-arago-tisdk-multimedia-sdk-target \
    packagegroup-arago-tisdk-connectivity-sdk-target \
    packagegroup-arago-tisdk-crypto-sdk-target \
"

TISDK_TOOLCHAIN_BASE_TARGET_keystone = "packagegroup-arago-standalone-sdk-target"

RDEPENDS_${PN} = "\
    ${QT_TOOLCHAIN_TARGET} \
    ${TISDK_TOOLCHAIN_BASE_TARGET} \
    ${@base_contains('MACHINE_FEATURES','sgx','packagegroup-arago-tisdk-graphics-sdk-target','',d)} \
    packagegroup-arago-tisdk-addons-sdk-target \
"
