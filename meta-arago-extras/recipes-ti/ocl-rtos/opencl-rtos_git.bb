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
           ti-xdctools-native \
           ti-ipc-rtos  \
           opencl-monitor-rtos  \
           clocl-rtos-native  \
           ti-cgt6x-native \
"

#RDEPENDS_${PN}-dev += " opencl-monitor-rtos"

ALLOW_EMPTY_${PN}-runtime = "1"


S = "${WORKDIR}/git/host"
B = "${WORKDIR}/build"

export WANT_LLVM_RELEASE = "3.6-ti"

OCL_BUILD_TARGET_omap-a15   = "ARM_AM57"

ENABLE_ULM = "0"

RELEASE_TARGET = ""
RELEASE_TARGET_omap-a15 = "am57xx"

export TI_OCL_CGT_INSTALL = "${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x"
export ARM_LLVM_DIR="${LLVM_RTOS_INSTALL_DIR}"
export DESTDIR="${D}${OCL_RTOS_INSTALL_DIR_RECIPE}/ti-opencl-rtos-${RELEASE_TARGET}-${PV}/packages/ti/opencl"

# Required for eclipse plugin and packages
export XDC_DIR = "${XDC_INSTALL_DIR}"
export BIOS_DIR = "${SYSBIOS_INSTALL_DIR}"
export IPC_DIR = "${IPC_INSTALL_DIR}"

do_configure() {
    unset LDFLAGS
    unset TARGET_LDFLAGS

    rm -rf "${B}"

    mkdir -p "${B}"
    cd "${B}"; cmake \
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
        -DOCL_VERSION=${PV} "${S}";
}

do_compile() {
    unset LDFLAGS
    unset TARGET_LDFLAGS

    oe_runmake
    oe_runmake -C packages
}

# Install x86/Linux clocl built by clocl-rtos-native recipe
do_install() {
    unset LDFLAGS
    unset TARGET_LDFLAGS

    oe_runmake install
    oe_runmake -C packages install

    install -d ${D}/usr/share/ti/opencl/bin/x86
    install -m 755 ${STAGING_DIR_NATIVE}/usr/share/ti/ti-opencl-rtos-tree/bin/x86/clocl ${D}/usr/share/ti/opencl/bin/x86
}

FILES_${PN}-dev += "/usr/share/ti/opencl ${OCL_RTOS_INSTALL_DIR_RECIPE}"

INSANE_SKIP_${PN} = "already-stripped"
INSANE_SKIP_${PN}-dev = "staticdev file-rdeps arch"
