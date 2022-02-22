SUMMARY = "TI OpenVX HOST (Linux A15) side library"
DESCRIPTION = "TI OpenVX implementation, TIOVX, based on Khronos OpenVX framework implementation including multiple C66 optimized kernels. \
Khronos defined conformance test is part of this package as well as additional TI specific tests. Few tutorial examples are also included. \
This package creates necessary libraries and header files for Linux Host side only. "

LICENSE = "TI-TSPA"
LIC_FILES_CHKSUM = "file://docs/manifest/TIOVX_manifest.html;md5=edd4fbfc6c1f01c20d49def4670efac0"

require recipes-ti/includes/arago-paths.inc

COMPATIBLE_MACHINE = "dra7xx"
PACKAGE_ARCH = "${MACHINE_ARCH}"

PV = "01.00.00.00"
PR = "r1"

BRANCH = "master"
SRC_URI = "git://git.ti.com/processor-sdk/tiovx.git;protocol=git;branch=${BRANCH}"
SRC_URI += "file://0001-Fix-paths-for-Yocto-build-and-add-RTOS-build-var.patch "
SRCREV = "2bfa01201804eaf2e675c743e708e88ab612049e"

S = "${WORKDIR}/git"

DEPENDS = "tiovx-sys-iface"

EXTRA_OEMAKE += " GCCLINARO=${TOOLCHAIN_PATH} "
EXTRA_OEMAKE += " SDKPLATFORMIFPATH=${TIOVX_INSTALL_DIR}/sys-iface BUILD_RTOS=no "

do_install () {
    CP_ARGS="-Prf --preserve=mode,timestamps --no-preserve=ownership"
    install -d ${D}${includedir}/VX
    install -d ${D}${includedir}/VX/TI
    install -d ${D}${libdir}
    cp ${CP_ARGS} ${S}/lib/TDAX/A15/LINUX/release/*.a ${D}${libdir}
    cp ${CP_ARGS} ${S}/include/VX/* ${D}${includedir}/VX
    cp ${CP_ARGS} ${S}/include/TI/* ${D}${includedir}/VX/TI
}

FILES:${PN}-staticdev = "${libdir}"
FILES:${PN}-dev = "${includedir}"

ALLOW_EMPTY:${PN} = "1"
