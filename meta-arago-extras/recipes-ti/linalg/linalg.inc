HOMEPAGE = "git://git.ti.com/dense-linear-algebra-libraries/linalg.git"
LICENSE = "BSD-3-Clause"

PV = "1_2_0_0"
INC_PR = "r2"

S = "${WORKDIR}/git"

require recipes-ti/includes/arago-paths.inc
require recipes-ti/includes/ti-staging.inc

BRANCH = "master"
SRC_URI = "git://git.ti.com/dense-linear-algebra-libraries/linalg.git;protocol=git;branch=${BRANCH}"
LIC_FILES_CHKSUM = "file://src/ti/linalg/docs/LINALG_1.2.0_manifest.html;md5=f30895e41e5947c3439b1ad4cf4c8555"
SRCREV = "f85a37ee21113e5839a64ac61009b1e2dde10fbc"

DEPENDS = "common-csl-ip \
           libarch \
           ti-xdctools \
           ti-ipc-rtos \
           ti-sysbios \
           ti-cgt6x-native \
           ti-xdais \
           ti-framework-components \
           libulm \
           openmp-rtos \
           opencl \
           clocl-native \
"

export TI_OCL_INSTALL_DIR = "${STAGING_DIR_TARGET}/usr/share/ti/opencl"
export CGTROOT = "${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x"
export TI_OCL_CGT_INSTALL = "${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x"
export XDC_DIR = "${XDC_INSTALL_DIR}"
export BIOS_DIR= "${SYSBIOS_INSTALL_DIR}"
export XDAIS_DIR = "${XDAIS_INSTALL_DIR}"
export FC_DIR = "${FC_INSTALL_DIR}"
export PDK_DIR = "${PDK_INSTALL_DIR}"
export OMP_DIR ="${OMP_INSTALL_DIR}"
export LIBARCH_DIR = "${LIBARCH_INSTALL_DIR}"
export TARGET_ROOTDIR="${STAGING_DIR_TARGET}"

COMPATIBLE_MACHINE = "k2hk-evm|am57xx"
