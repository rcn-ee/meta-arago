DESCRIPTION = "Task to build and install header and libs into the sdk"
LICENSE = "MIT"
PR = "r14"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

TISDK_TOOLCHAIN_BASE_TARGET = "\
    packagegroup-arago-standalone-sdk-target \
    packagegroup-arago-tisdk-multimedia-sdk-target \
"

TISDK_TOOLCHAIN_EXTRA_TARGET = "\
    packagegroup-arago-tisdk-connectivity-sdk-target \
    packagegroup-arago-tisdk-crypto-sdk-target \
"
TISDK_TOOLCHAIN_EXTRA_TARGET:omapl138 = ""

RDEPENDS:${PN} = "\
    ${@bb.utils.contains('DISTRO_FEATURES','opengl','packagegroup-arago-qte-toolchain-target','',d)} \
    ${@bb.utils.contains('DISTRO_FEATURES','opengl','packagegroup-arago-tisdk-gtk-sdk-target','',d)} \
    ${TISDK_TOOLCHAIN_BASE_TARGET} \
    ${TISDK_TOOLCHAIN_EXTRA_TARGET} \
    ${@bb.utils.contains('DISTRO_FEATURES','opengl','packagegroup-arago-tisdk-graphics-sdk-target','',d)} \
    ${@['','packagegroup-arago-tisdk-opencl-sdk-target'][oe.utils.all_distro_features(d, 'opencl', True, False) and bb.utils.contains('MACHINE_FEATURES', 'dsp', True, False, d)]} \
    packagegroup-arago-tisdk-addons-sdk-target \
"
