SUMMARY = "TI OpenCL-C compiler for C66x (Linux hosted)"
HOMEPAGE = "http://software-dl.ti.com/mctools/docs/opencl/intro.html"
LICENSE = "BSD"

require recipes-ti/ocl/ocl.inc
require recipes-ti/includes/arago-paths.inc

PR = "${INC_PR}.0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "ti-llvm3.6-native boost-native"

S = "${WORKDIR}/git/host"

TARGET_class-target = "am57xx"
TARGET_class-native = "x86"

export WANT_LLVM_RELEASE = "3.6-ti"
export DESTDIR="${D}${OCL_RTOS_INSTALL_DIR_RECIPE}"
export LDFLAGS="${BUILD_LDFLAGS}"
export CXXFLAGS="${BUILD_CFLAGS}"

EXTRA_OEMAKE = "CXX=${BUILD_CXX} \
                -C ${S}/clocl \
                 _PRODUCT_VERSION=${PV} \
                 TARGET=x86 \
                 LLVM_CONFIG_EXE=llvm-config \
"

do_compile() {
  oe_runmake
}

do_install() {
    install -d ${DESTDIR}/bin/x86
    install -m 755 ${S}/clocl/x86/clocl ${DESTDIR}/bin/x86/
}

BBCLASSEXTEND = "native"
