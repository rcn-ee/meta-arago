SUMMARY = "TI OpenMP-Acc C compiler"

include openmpacc.inc

PR = "${INC_PR}.0"

DEPENDS = "boost elfutils"
RDEPENDS_${PN} += "clocl"

S = "${WORKDIR}/git/host"

TARGET_class-target = "clacc_arm"
TARGET_class-native = "clacc_x86"
TARGET_class-nativesdk = "clacc_x86"

export LINUX_DEVKIT_ROOT = "${STAGING_DIR_HOST}"
export X86_HOST_ROOT = "${STAGING_DIR_HOST}"

PARALLEL_MAKE = ""

# The variables CLACC_CC and CLACC_CXX are used to point clacc to set its
# host_cc and host_link_cc variables which were previously hardcoded in clacc.h.
# This adds support for different toolchain configurations to build clacc by
# passing in the compiler names at the build stage and removes corresponding
# string replacement requirements in yocto recipes.
python __anonymous() {
    cc_name = ""
    cxx_name = ""
    if d.getVar("TOOLCHAIN_PREFIX"):
        cc_name = d.getVar("TOOLCHAIN_PREFIX") + "gcc"
        cxx_name = d.getVar("TOOLCHAIN_PREFIX") + "g++"
    else:
        cc_name = d.getVar("TARGET_PREFIX") + "gcc"
        cxx_name = d.getVar("TARGET_PREFIX") + "g++"

    # Convert to upper case to workaround GCC preprocessor bug where the word
    # 'linux' is defined to be 1. This results in arm-linux-gnueabihf- being
    # stringized to arm-1-gnueabihf- by the GCC preprocessor. To workaround this
    # bug, convert the names to upper case and send through. Clacc will convert
    # to lower case before usage.
    d.setVar("CLACC_CC_NAME", cc_name.upper())
    d.setVar("CLACC_CXX_NAME", cxx_name.upper())
}


EXTRA_OEMAKE = " -C ${S}/clacc \
                  ${TARGET} \
                  CXX="${CXX}" \
                  CLACC_CC="${CLACC_CC_NAME}" \
                  CLACC_CXX="${CLACC_CXX_NAME}" \
"

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
