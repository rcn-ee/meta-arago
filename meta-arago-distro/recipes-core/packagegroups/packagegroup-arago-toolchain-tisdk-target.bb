DESCRIPTION = "Task to build and install header and libs into the sdk"
LICENSE = "MIT"
PR = "r9"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

QT_TOOLCHAIN_TARGET = "\
    packagegroup-arago-qte-toolchain-target \
"

QT_TOOLCHAIN_TARGET_keystone = ""
QT_TOOLCHAIN_TARGET_omapl138 = ""

TISDK_TOOLCHAIN_BASE_TARGET = "\
    packagegroup-arago-tisdk-multimedia-sdk-target \
    packagegroup-arago-tisdk-connectivity-sdk-target \
    packagegroup-arago-tisdk-crypto-sdk-target \
"

TISDK_TOOLCHAIN_BASE_TARGET_keystone = "packagegroup-arago-standalone-sdk-target"

RDEPENDS_${PN} = "\
    ${QT_TOOLCHAIN_TARGET} \
    ${TISDK_TOOLCHAIN_BASE_TARGET} \
    ${@bb.utils.contains('MACHINE_FEATURES','sgx','packagegroup-arago-tisdk-graphics-sdk-target','',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES','dsp','packagegroup-arago-tisdk-opencl-sdk-target','',d)} \
    packagegroup-arago-tisdk-addons-sdk-target \
"
