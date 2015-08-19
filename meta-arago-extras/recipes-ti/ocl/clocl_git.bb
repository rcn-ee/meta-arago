DESCRIPTION = "TI OpenCL offline C compiler for compute devices"
HOMEPAGE = "http://software-dl.ti.com/mctools/docs/opencl/intro.html"
LICENSE = "BSD"

include ocl.inc

PR = "${INC_PR}.0"

DEPENDS = "ti-llvm3.3 ti-llvm3.3-native boost"

S = "${WORKDIR}/git/host"

export WANT_LLVM_RELEASE = "3.3-ti"

TARGET_class-target = "arm"
TARGET_class-native = "x86"
TARGET_class-nativesdk = "x86"

EXTRA_OEMAKE = " -C ${S}/clocl \
                 _PRODUCT_VERSION=${PV} \
                 TARGET=${TARGET} \
                 LLVM_CONFIG_EXE=llvm-config \
"

do_compile() {
  oe_runmake
}

do_install() {
  install -d ${D}${bindir}
  install -m 755 ${S}/clocl/${TARGET}/clocl ${D}${bindir}
}

BBCLASSEXTEND = "native nativesdk"
