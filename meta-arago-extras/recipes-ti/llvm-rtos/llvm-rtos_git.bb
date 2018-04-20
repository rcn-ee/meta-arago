SUMMARY = "Bare-metal build of a subset of LLVM 3.6 with support for TI C66x"
HOMEPAGE = "http://git.ti.com/opencl/llvm"
DESCRIPTION = "A subset of LLVM 3.6 libraries built using gcc-arm-none-eabi-native. Used in the OpenCL running over a TI-RTOS based host."

# 3-clause BSD-like
# University of Illinois/NCSA Open Source License
LICENSE = "NCSA"


require llvm-rtos.inc
require recipes-ti/includes/arago-paths.inc

PR = "${INC_PR}.0"

DEPENDS = "gcc-arm-none-eabi-native cmake-native"

COMPATIBLE_MACHINE = "omap-a15"
PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/git"
RELEASE_TARGET = ""
RELEASE_TARGET_omap-a15 = "am57xx"

CLEANBROKEN = "1"

export LLVM_SRC_DIR="${S}"
export LLVM_INSTALL_DIR="${D}${LLVM_RTOS_INSTALL_DIR_RECIPE}"

do_compile() {
    unset LDFLAGS
    unset TARGET_LDFLAGS

    # Clean the build directory
    rm -rf build.sysbios

    mkdir -p build.sysbios/build.native
    cd build.sysbios/build.native; CC="${BUILD_CC}" CXX="${BUILD_CXX}" cmake "${S}"; cd ../..
    make -C build.sysbios/build.native llvm-tblgen llvm-config ${PARALLEL_MAKE}

    cd build.sysbios; cmake -DCMAKE_TOOLCHAIN_FILE="${S}/ToolChain_ARMSysBios.cmake" -Wno-dev "${S}"; cd ..

    make -C build.sysbios LLVMSupport LLVMCore LLVMBitReader ${PARALLEL_MAKE}

}

do_install() {
    cd build.sysbios; make -f include/llvm/Makefile install/local; cd ..

    install -d ${D}${LLVM_RTOS_INSTALL_DIR_RECIPE}/bin
    install -m 755 ${S}/build.sysbios/build.native/bin/llvm-config ${D}${LLVM_RTOS_INSTALL_DIR_RECIPE}/bin/llvm-config-host

    install -d ${D}${LLVM_RTOS_INSTALL_DIR_RECIPE}/lib
    for libfile in ${S}/build.sysbios/lib/*.a; do
        install -m 644 ${libfile} ${D}${LLVM_RTOS_INSTALL_DIR_RECIPE}/lib
    done
}

FILES_${PN} += "${LLVM_RTOS_INSTALL_DIR_RECIPE}"

# This package contains one x86-64 executable and a few static libraries
INSANE_SKIP_${PN} = "arch file-rdeps staticdev"

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_SYSROOT_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
