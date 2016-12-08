SUMMARY = "TI OpenMP-Acc C compiler"

include openmpacc.inc

PR = "${INC_PR}.1"

DEPENDS = "boost elfutils"
RDEPENDS_${PN} += "clocl"

S = "${WORKDIR}/git/host"

TARGET_class-target = "clacc_arm"
TARGET_class-native = "clacc_x86"
TARGET_class-nativesdk = "clacc_x86"

export LINUX_DEVKIT_ROOT = "${STAGING_DIR_HOST}"
export X86_HOST_ROOT = "${STAGING_DIR_HOST}"

PARALLEL_MAKE = ""

EXTRA_OEMAKE = " -C ${S}/clacc \
                  ${TARGET} \
                  CXX="${CXX}" \
"

do_configure() {
    sed "s|arm-linux-gnueabihf-gcc|${TOOLCHAIN_PREFIX}gcc|g" -i clacc/clacc.h
    sed "s|arm-linux-gnueabihf-g++|${TOOLCHAIN_PREFIX}g++|g" -i clacc/clacc.h
}

do_compile() {
    oe_runmake
}

do_install() {
    install -d ${D}${bindir}
    install -m 755 clacc/${TARGET} ${D}${bindir}/clacc

    install -d ${D}${mandir}/man1
    install -m 644 clacc/clacc.1 ${D}${mandir}/man1
}

BBCLASSEXTEND = "native nativesdk"
