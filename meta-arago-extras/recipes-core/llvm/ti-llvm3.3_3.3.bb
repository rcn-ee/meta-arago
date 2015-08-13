DESCRIPTION = "LLVM 3.3 with support for TI C66x intrinsics"
HOMEPAGE = "https://gitorious.design.ti.com/ocl/llvm33-src"

PR = "r1"

do_configure_prepend_class-native() {
    # Fix paths in llvm-config
    sed -i "s|sys::path::parent_path(sys::path::parent_path(CurrentPath))).str()|sys::path::parent_path(CurrentPath))\.str()|g" ${S}/tools/llvm-config/llvm-config.cpp
}

require recipes-core/llvm/llvm.inc

DEPENDS += "zlib libxml2"
EXTRA_OECONF += "--enable-zlib"


LLVM_DIR = "ti-llvm${PV}"

BRANCH = "master"

SRC_URI = " \
  git://git.ti.com/opencl/ti-llvm-clang-3_3.git;protocol=git;branch=${BRANCH} \
  file://0001-configure-Do-not-check-build-executable-extension.patch \
"


SRCREV = "29629a3e70d445cfbfbb4046a56d3648ebae9544"

S = "${WORKDIR}/git"

LIBXML2_INC = "`pkg-config libxml-2.0 --cflags`"
LIBXML2_LIBS = "`pkg-config libxml-2.0 --libs`"

EXTRA_OEMAKE += "LIBXML2_INC="${LIBXML2_INC}" LIBXML2_LIBS="${LIBXML2_LIBS}""

do_compile_class-native() {
  cd ${LLVM_BUILD_DIR}
  oe_runmake
}

do_compile_class-nativesdk() {
    cd ${LLVM_BUILD_DIR}
    oe_runmake \
        AR="${BUILD_AR}" \
        CC="${BUILD_CC}" \
        CFLAGS="${BUILD_CFLAGS}" \
        CXX="${BUILD_CXX}" \
        CXXFLAGS="${BUILD_CXXFLAGS}" \
        CPP="${BUILD_CPP}" \
        CPPFLAGS="${BUILD_CPPFLAGS}" \
        LD="${BUILD_LD}" \
        LDFLAGS="${BUILD_LDFLAGS}" \
        NM="${BUILD_NM}" \
        RANLIB="${BUILD_RANLIB}" \
        PATH="${STAGING_BINDIR_NATIVE}:$PATH" \
        cross-compile-build-tools
    oe_runmake
}

do_install_append_class-target() {
    for b in ${D}${bindir}/${LLVM_DIR}/${HOST_SYS}-clang*; do
        if [ ! -L ${b} ]; then
            mv ${b} ${D}${bindir}/`echo "${b}" | sed -e 's|${D}${bindir}/${LLVM_DIR}/${HOST_SYS}-||g'`
        fi
    done
}

do_install_class-native() {
    cd ${LLVM_BUILD_DIR}
    oe_runmake DESTDIR=${LLVM_INSTALL_DIR} install

    mv ${LLVM_INSTALL_DIR}${bindir}/${HOST_SYS}-llvm-config ${LLVM_INSTALL_DIR}/llvm-config${PV}-ti

    install -d ${D}${bindir}
    for b in ${LLVM_INSTALL_DIR}${bindir}/${HOST_SYS}-clang*; do
        if [ ! -L ${b} ]; then
            mv ${b} ${D}${bindir}/`echo "${b}" | sed -e 's|${LLVM_INSTALL_DIR}${bindir}/${HOST_SYS}-||g'`
        fi
    done

    install -d ${D}${bindir}/${LLVM_DIR}
    mv ${LLVM_INSTALL_DIR}${bindir}/* ${D}${bindir}/${LLVM_DIR}/

    install -d ${D}${includedir}/${LLVM_DIR}
    mv ${LLVM_INSTALL_DIR}${includedir}/* ${D}${includedir}/${LLVM_DIR}/

    install -d ${D}${libdir}/${LLVM_DIR}
    mv ${LLVM_INSTALL_DIR}${libdir}/* ${D}${libdir}/${LLVM_DIR}/
    ln -s ${LLVM_DIR}/libLLVM-${PV}.so ${D}${libdir}/libLLVM-${PV}.so

    install -d ${D}${docdir}/${LLVM_DIR}
    mv ${LLVM_INSTALL_DIR}${prefix}/docs/llvm/* ${D}${docdir}/${LLVM_DIR}

    install -d ${D}${bindir}
    install -m 0755 ${LLVM_INSTALL_DIR}/llvm-config${PV}-ti ${D}${bindir}
}

SYSROOT_PREPROCESS_FUNCS_class-target += "llvm_sysroot_preprocess_target"
SYSROOT_PREPROCESS_FUNCS_class-nativesdk += "llvm_sysroot_preprocess_target"

llvm_sysroot_preprocess() {
    :
}

llvm_sysroot_preprocess_target() {
    install -d ${SYSROOT_DESTDIR}${bindir_crossscripts}
    mv ${LLVM_INSTALL_DIR}/llvm-config-host ${SYSROOT_DESTDIR}${bindir_crossscripts}/llvm-config${PV}-ti
}

BBCLASSEXTEND = "native nativesdk"
