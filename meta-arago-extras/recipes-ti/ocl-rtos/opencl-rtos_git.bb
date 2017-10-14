SUMMARY = "TI OpenCL host runtime (RTOS)"
HOMEPAGE = "http://software-dl.ti.com/mctools/docs/opencl/intro.html"
LICENSE = "BSD"

require recipes-ti/ocl/ocl.inc
require recipes-ti/includes/arago-paths.inc

PR = "${INC_PR}.0"


COMPATIBLE_MACHINE = "omap-a15"
PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES += " ${PN}-runtime"

DEPENDS = "cmake-native \
           llvm-rtos \
           libloki \
           gcc-arm-none-eabi-native \
           ti-sysbios \
           ti-xdctools \
           ti-ipc-rtos  \
           opencl-monitor-rtos  \
           clocl-rtos-native  \
"

#RDEPENDS_${PN}-dev += " opencl-monitor-rtos"

ALLOW_EMPTY_${PN}-runtime = "1"


S = "${WORKDIR}/git/host"

export WANT_LLVM_RELEASE = "3.6-ti"

OCL_BUILD_TARGET_omap-a15   = "ARM_AM57"

ENABLE_ULM = "0"

RELEASE_TARGET = ""
RELEASE_TARGET_omap-a15 = "am57xx"

export TI_OCL_CGT_INSTALL = "${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x"
export ARM_LLVM_DIR="${LLVM_RTOS_INSTALL_DIR}"
export DESTDIR="${OCL_RTOS_INSTALL_DIR}/ti-opencl-rtos-${RELEASE_TARGET}-${PV}/packages/ti/opencl"

# Required for eclipse plugin and packages
export XDC_DIR = "${XDC_INSTALL_DIR}"
export BIOS_DIR = "${SYSBIOS_INSTALL_DIR}"
export IPC_DIR = "${IPC_INSTALL_DIR}"

do_compile() {

    echo "LLVM_RTOS_INSTALL_DIR=${LLVM_RTOS_INSTALL_DIR}"

    unset LDFLAGS
    unset TARGET_LDFLAGS

    cd ${WORKDIR}
    rm -rf build

    mkdir -p build
    cd build; cmake \
        -DCMAKE_TOOLCHAIN_FILE=../git/host/cmake/CMakeBiosARMToolChain.txt \
        -DBUILD_TARGET=${OCL_BUILD_TARGET} \
        -DBUILD_OUTPUT=lib \
        -DENABLE_ULM=${ENABLE_ULM} \
        -DBUILD_OS=SYS_BIOS \
        -DIPC_INSTALL_PATH=${IPC_INSTALL_DIR}/packages \
        -DXDC_INSTALL_PATH=${XDC_INSTALL_DIR}/packages \
        -DBIOS_INSTALL_PATH=${SYSBIOS_INSTALL_DIR}/packages \
        -DLOKI_INCLUDE_PATH=${STAGING_DIR_HOST}/usr/include/loki \
        -DARM_LLVM_DIR=${ARM_LLVM_DIR} \
        -DOCL_VERSION=${PV} ../git/host;
    make install
    make -C eclipse install
    make -C packages install
    cd ..
}

# Install x86/Linux clocl built by clocl-rtos-native recipe
do_install() {
    install -d ${DESTDIR}/usr/share/ti/opencl/bin/x86
    install -m 755 ${STAGING_DIR_NATIVE}/usr/share/ti/ti-opencl-rtos-tree/bin/x86/clocl ${DESTDIR}/usr/share/ti/opencl/bin/x86
}
