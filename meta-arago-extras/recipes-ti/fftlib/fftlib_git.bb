SUMMARY = "TI FFTLIB"
HOMEPAGE = "http://git.ti.com/fftlib/fftlib"
LICENSE = "BSD-3-Clause"

LIC_FILES_CHKSUM = "file://ti/fftlib/docs/manifest/manifest.xml.xdt;md5=178402e86abc15ff3bac0d4fc57e5463"

include fftlib.inc

PR = "${INC_PR}.0"

DEPENDS = "common-csl-ip-rtos libarch ti-xdctools-native doxygen-native ti-cgt6x-native ti-xdais libulm dsplib-c66x php libxslt-native libxslt openmp-rtos"

COMPATIBLE_MACHINE = "k2hk|dra7xx"

TARGET_dra7xx = "SOC_AM572x"
TARGET_k2hk   = "SOC_K2H"
PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/git"

export FFTLIB_ROOT="${S}"
export DOXYGEN_DIR="${DOXYGEN_INSTALL_DIR}"

export TI_OCL_INSTALL_DIR = "${STAGING_DIR_TARGET}/usr/share/ti/opencl"
export CGTROOT = "${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x"
export TI_OCL_CGT_INSTALL = "${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x"
export XDC_DIR = "${XDC_INSTALL_DIR}"
export BIOS_DIR = "${SYSBIOS_INSTALL_DIR}"
export XDAIS_DIR = "${XDAIS_INSTALL_DIR}"
export FC_DIR = "${FC_INSTALL_DIR}"
export PDK_DIR = "${PDK_INSTALL_DIR}"
export OMP_DIR ="${OMP_INSTALL_DIR}"
export IPC_DIR = "${IPC_INSTALL_DIR}/packages"
export LIBARCH_DIR = "${LIBARCH_INSTALL_DIR}"
export TARGET_ROOTDIR ="${STAGING_DIR_TARGET}"

export X86_LLVM_DIR = "${STAGING_DIR_NATIVE}/usr"
export C6636_PDK_DIR ="${PDK_INSTALL_DIR}/packages"
export XDCCGROOT = "${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x"
export LINUX_DEVKIT_ROOT = "${STAGING_DIR_TARGET}"

export PDK_INSTALL_DIR
export FC_INSTALL_DIR
export IPC_INSTALL_DIR
export XDC_INSTALL_DIR
export XDAIS_INSTALL_DIR

export OPENMP_INSTALL_DIR="${OMP_INSTALL_DIR}"
export BIOS_INSTALL_DIR="${SYSBIOS_INSTALL_DIR}"
export EDMA_INSTALL_DIR="${EDMA3_LLD_INSTALL_DIR}"
export C66CODEGENTOOL="${TI_OCL_CGT_INSTALL}"
export C64CODEGENTOOL="${TI_OCL_CGT_INSTALL}"
export TI_DOXYGEN_TEMPLATES="${DOXYGEN_DIR}/TI_Templates/10-01-2007"
export XDCBUILDCFG="${FFTLIB_ROOT}/ti/mas/swtools/config.bld"
export FFTLIB_INSTALL_DIR="${FFTLIB_ROOT}"
export IPC_DIR="{IPC_INSTALL_DIR}"

XDCPATH.="${XDCCGROOT}/include;"
XDCPATH.="${XDAIS_INSTALL_DIR}/packages;"
XDCPATH.="${XDC_INSTALL_DIR}/packages;"
XDCPATH.="${FFTLIB_INSTALL_DIR};"
XDCPATH.="${FC_INSTALL_DIR}/packages;"
XDCPATH.="${OMP_INSTALL_DIR}/packages;"
XDCPATH.="${PDK_INSTALL_DIR}/packages;"
XDCPATH.="${BIOS_INSTALL_DIR}/packages;"
XDCPATH.="${EDMA3_LLD_INSTALL_DIR}/packages;"
XDCPATH.="${DSPLIB_C66_INSTALL_DIR}/packages;"
XDCPATH.="${IPC_INSTALL_DIR}/packages;"
XDCPATH.="${LIBARCH_INSTALL_DIR}/packages;"
XDCPATH.="${TI_OCL_INSTALL_DIR};"

XDCPATH.="${FFTLIB_ROOT}"

export XDCPATH
export PATH := "${XDC_INSTALL_DIR}:${PATH}"


do_compile() {
   echo "Building the FFTLIB.zip"
   cd ${FFTLIB_ROOT}/ti/fftlib
   xdc XDCARGS="${TARGET} c66x armplusdsp bundle" XDCOPTIONS="-v"
}

do_install() {

   cd ${FFTLIB_ROOT}/ti/fftlib
   install -d ${D}${FFTLIB_INSTALL_DIR_RECIPE}

   find -name "fftlib*.zip" -exec unzip -o {} -d ${D}${FFTLIB_INSTALL_DIR_RECIPE} \;
   mv ${D}${FFTLIB_INSTALL_DIR_RECIPE}/fftlib/* ${D}${FFTLIB_INSTALL_DIR_RECIPE}
   rm -r ${D}${FFTLIB_INSTALL_DIR_RECIPE}/fftlib

}

FILES_${PN}-dev += "${FFTLIB_INSTALL_DIR_RECIPE}"

# skip checking binary against ARM architecture
INSANE_SKIP_${PN}-dev = "arch"
ALLOW_EMPTY_${PN} = "1"
