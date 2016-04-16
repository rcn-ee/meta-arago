HOMEPAGE = "https://git.ti.com/library-architecture/libarch"
LICENSE = "BSD-3-Clause"

PV = "1_0_0_0"
INC_PR = "r1"

require recipes-ti/includes/arago-paths.inc
require recipes-ti/includes/ti-staging.inc

BRANCH = "master"
LIC_FILES_CHKSUM = "file://src/ti/libarch/docs/LibArch_1.0.0_manifest.html;md5=bb48cacb8827ec8d8e5a94c4f2425ee3"
SRC_URI = "git://git.ti.com/library-architecture/libarch.git;protocol=git;branch=${BRANCH}"
SRCREV = "4b2f1c5d5b6b9f3d021e498120a914456fb9eba1"

COMPATIBLE_MACHINE = "k2hk-evm|am57xx"
PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/git"

DEPENDS = "common-csl-ip-rtos ti-xdctools ti-sysbios ti-cgt6x-native ti-xdais ti-framework-components opencl opencl-monitor"

export CGTROOT = "${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x"
export TI_OCL_CGT_INSTALL = "${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x"
export TI_OCL_INSTALL_DIR = "${STAGING_DIR_TARGET}/usr/share/ti/opencl"
export XDC_DIR = "${XDC_INSTALL_DIR}"
export BIOS_DIR= "${SYSBIOS_INSTALL_DIR}"
export XDAIS_DIR = "${XDAIS_INSTALL_DIR}"
export FC_DIR = "${FC_INSTALL_DIR}"
export PDK_DIR = "${PDK_INSTALL_DIR}"

TARGET_am57xx-evm = "SOC_AM572x"
TARGET_k2hk-evm   = "SOC_K2H"
