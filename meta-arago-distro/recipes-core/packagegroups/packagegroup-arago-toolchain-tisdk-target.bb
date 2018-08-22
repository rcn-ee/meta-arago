DESCRIPTION = "Task to build and install header and libs into the sdk"
LICENSE = "MIT"
PR = "r13"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

QT_TOOLCHAIN_TARGET = "\
    packagegroup-arago-qte-toolchain-target \
"
QT_TOOLCHAIN_TARGET_keystone = ""
QT_TOOLCHAIN_TARGET_omapl138 = ""

GTK_TOOLCHAIN_TARGET = "\
    packagegroup-arago-gtk-sdk-target \
"
GTK_TOOLCHAIN_TARGET_keystone = ""
GTK_TOOLCHAIN_TARGET_omapl138 = ""

TISDK_TOOLCHAIN_BASE_TARGET = "\
    packagegroup-arago-standalone-sdk-target \
    packagegroup-arago-tisdk-multimedia-sdk-target \
"

TISDK_TOOLCHAIN_EXTRA_TARGET = "\
    packagegroup-arago-tisdk-connectivity-sdk-target \
    packagegroup-arago-tisdk-crypto-sdk-target \
"
TISDK_TOOLCHAIN_EXTRA_TARGET_keystone = ""
TISDK_TOOLCHAIN_EXTRA_TARGET_omapl138 = ""

RDEPENDS_${PN} = "\
    ${QT_TOOLCHAIN_TARGET} \
    ${GTK_TOOLCHAIN_TARGET} \
    ${TISDK_TOOLCHAIN_BASE_TARGET} \
    ${TISDK_TOOLCHAIN_EXTRA_TARGET} \
    ${@bb.utils.contains('MACHINE_FEATURES','sgx','packagegroup-arago-tisdk-graphics-sdk-target','',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES','dsp','packagegroup-arago-tisdk-opencl-sdk-target','',d)} \
    packagegroup-arago-tisdk-addons-sdk-target \
"
