SUMMARY = "TI FFTW"
HOMEPAGE = "http://git.ti.com/fftlib"
LICENSE = "GPL-2.0 & BSD-3-Clause"

LIC_FILES_CHKSUM = "file://docs/TI-FFTW_3.1.0_manifest.html;md5=aaa275ec704a738216ba696898941b44 \
                    file://fftw-3.3.4/COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

include fftlib.inc

PR = "${INC_PR}.0"

DEPENDS = "common-csl-ip-rtos common-csl-ip ti-xdctools-native ti-sysbios ti-cgt6x-native ti-xdais libulm fftlib dsplib-c66x opencl clocl-native libarch"

RDEPENDS_${PN} += "opencl-runtime"

COMPATIBLE_MACHINE = "k2hk|dra7xx"
TARGET_dra7xx = "SOC_AM572x"
TARGET_k2hk   = "SOC_K2H"
PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/git/ti/fftw"

export TI_OCL_INSTALL_DIR = "${STAGING_DIR_TARGET}/usr/share/ti/opencl"
export TI_OCL_CGT_INSTALL = "${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x"
export PDK_DIR = "${PDK_INSTALL_DIR}"
export IPC_DIR = "${IPC_INSTALL_DIR}/packages"
export XDC_DIR = "${XDC_INSTALL_DIR}"
export BIOS_DIR = "${SYSBIOS_INSTALL_DIR}"
export XDAIS_DIR = "${XDAIS_INSTALL_DIR}"
export FC_DIR = "${FC_INSTALL_DIR}"
export ULM_DIR ="${STAGING_DIR_TARGET}/usr/share/ti/ulm"
export GDB_SERVER_DIR = "${STAGING_DIR_TARGET}/usr/share/ti/gdbc6x"
export X86_LLVM_DIR = "${STAGING_DIR_NATIVE}/usr"
export C6636_PDK_DIR ="${PDK_INSTALL_DIR}/packages"
export XDCCGROOT = "${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x"
export LINUX_DEVKIT_ROOT = "${STAGING_DIR_TARGET}"
export TARGET_ROOTDIR="${STAGING_DIR_TARGET}"
export OMP_DIR = "${OMP_INSTALL_DIR}"
export FFTLIB_DIR="${FFTLIB_INSTALL_DIR}"
export DSPLIB_DIR="${DSPLIB_C66_INSTALL_DIR}"
export BIOS_INSTALL_DIR="${SYSBIOS_INSTALL_DIR}"
export EDMA_INSTALL_DIR="${EDMA3_LLD_INSTALL_DIR}"
export XDCTOOLS_DIR="${XDC_INSTALL_DIR}/packages"
export LIBARCH_DIR = "${LIBARCH_INSTALL_DIR}"

do_compile() {
    make build TARGET=${TARGET}
}

do_install() {
    make install DESTDIR=${D}

    # These files will be installed by the ti-fftw-examples recipe
    rm -rf ${D}${datadir}/ti
}

ALLOW_EMPTY_${PN} = "1"

INSANE_SKIP_${PN} = "arch"
