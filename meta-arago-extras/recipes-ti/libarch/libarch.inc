HOMEPAGE = "https://git.ti.com/library-architecture/libarch"
LICENSE = "BSD-3-Clause"

PV = "1_0_0_0"
INC_PR = "r2"

require recipes-ti/includes/arago-paths.inc
require recipes-ti/includes/ti-staging.inc

BRANCH = "master"
LIC_FILES_CHKSUM = "file://src/ti/libarch/docs/LibArch_1.0.0_manifest.html;md5=bb48cacb8827ec8d8e5a94c4f2425ee3"
SRC_URI = "git://git.ti.com/library-architecture/libarch.git;protocol=git;branch=${BRANCH}"
SRCREV = "cb6d785e95cd390c6388853a4f1e99a302e5a58f"

COMPATIBLE_MACHINE = "k2hk|dra7xx"
PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/git"

DEPENDS = "common-csl-ip-rtos ti-xdctools-native ti-sysbios ti-cgt6x-native ti-xdais ti-framework-components opencl opencl-monitor doxygen-native zip-native"

export CGTROOT = "${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x"
export TI_OCL_CGT_INSTALL = "${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x"
export TI_OCL_INSTALL_DIR = "${STAGING_DIR_TARGET}/usr/share/ti/opencl"
export XDC_DIR = "${XDC_INSTALL_DIR}"
export BIOS_DIR= "${SYSBIOS_INSTALL_DIR}"
export XDAIS_DIR = "${XDAIS_INSTALL_DIR}"
export FC_DIR = "${FC_INSTALL_DIR}"
export PDK_DIR = "${PDK_INSTALL_DIR}"

TARGET_dra7xx = "SOC_AM572x"
TARGET_k2hk   = "SOC_K2H"
