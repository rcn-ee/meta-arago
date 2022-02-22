DESCRIPTION = "TI OpenCL offline C compiler for compute devices"
HOMEPAGE = "https://downloads.ti.com/mctools/esd/docs/opencl/index.html"
LICENSE = "BSD"

include ocl.inc

PR = "${INC_PR}.0"

DEPENDS = "ti-llvm3.6 ti-llvm3.6-native boost"

S = "${WORKDIR}/git/host"

export WANT_LLVM_RELEASE = "3.6-ti"

TARGET:class-target = "arm"
TARGET:class-native = "x86"
TARGET:class-nativesdk = "x86"

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

RDEPENDS:${PN} += "ti-cgt6x"
BBCLASSEXTEND = "native nativesdk"
