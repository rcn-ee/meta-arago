DESCRIPTION = "TI OpenCL host runtime and development packages"
HOMEPAGE = "http://software-dl.ti.com/mctools/docs/opencl/intro.html"
LICENSE = "BSD"

include ocl.inc

PR = "${INC_PR}.0"

inherit cmake

COMPATIBLE_MACHINE = "dra7xx|keystone"
PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES += " ${PN}-runtime"

#            cmem
DEPENDS = " ocl-gl-headers \
            opencl-monitor \
            cmake-native \
            ti-llvm3.6 \
            ti-llvm3.6-native \
            binutils \
            sqlite3 \
            libffi \
            boost \
            boost-native \
            libloki \
            pkgconfig-native \
            libulm \
"

DEPENDS_append_dra7xx   = " ti-ipc virtual/kernel"
DEPENDS_append_keystone = " mpm-transport multiprocmgr"
DEPENDS_remove_k2g-evm  = " libulm"

RDEPENDS_${PN}-dev += " ocl-gl-headers-dev opencl-monitor"
RDEPENDS_${PN}-runtime += " ${PN} opencl-monitor clocl ti-cgt6x"

ALLOW_EMPTY_${PN}-runtime = "1"


S = "${WORKDIR}/git/host"

export WANT_LLVM_RELEASE = "3.6-ti"

OCL_BUILD_TARGET_dra7xx   = "ARM_AM57"
OCL_BUILD_TARGET_k2hk-evm = "ARM_K2H"
OCL_BUILD_TARGET_k2l-evm  = "ARM_K2L"
OCL_BUILD_TARGET_k2e-evm  = "ARM_K2E"
OCL_BUILD_TARGET_k2g-evm  = "ARM_K2G"

ENABLE_ULM = "1"
ENABLE_ULM_k2g-evm = "0"

EXTRA_OECMAKE += " -DBUILD_TARGET=${OCL_BUILD_TARGET} -DBUILD_OUTPUT=lib -DENABLE_ULM=${ENABLE_ULM}"

EXTRA_OEMAKE += "KERNEL_INSTALL_DIR=${STAGING_KERNEL_DIR} LINUX_DEVKIT_ROOT=${STAGING_DIR_HOST}"
export KERNEL_INSTALL_DIR = "${STAGING_KERNEL_DIR}"

FILES_${PN} += " \
    ${datadir}/ti/opencl/* \
"
