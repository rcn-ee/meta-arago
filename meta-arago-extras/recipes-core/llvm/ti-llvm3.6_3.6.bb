DESCRIPTION = "LLVM 3.6 with support for TI C66x intrinsics"
HOMEPAGE = "https://gitorious.design.ti.com/ocl/llvm33-src"

PR = "r6"

do_configure_prepend_class-native() {
    # Fix paths in llvm-config
    sed -i "s|sys::path::parent_path(sys::path::parent_path(CurrentPath))).str()|sys::path::parent_path(CurrentPath))\.str()|g" ${S}/tools/llvm-config/llvm-config.cpp
}

do_configure_prepend() {
    # Workaround for libdir fix for multilib to undo what is currently upstream
    sed -i 's:${base_libdir}:/${baselib}:g' ${S}/tools/llvm-config/llvm-config.cpp
}

require recipes-core/llvm/llvm.inc

LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=47e311aa9caedd1b3abf098bd7814d1d"

DEPENDS += "libxml2 groff-native"
DEPENDS_append_class-target = " valgrind"

LLVM_DIR = "ti-llvm${PV}"

LLVM_GIT_NAME = "llvm"
LLVM_GIT_URI = "git://git.ti.com/opencl/llvm.git"
LLVM_GIT_PROTOCOL = "git"
LLVM_GIT_BRANCH = "release_36_ti"
LLVM_GIT_DESTSUFFIX = "git"
LLVM_GIT_SRCREV = "8ff2a35c586a3d3f624712e0943777613a017bc5"

CLANG_GIT_NAME = "clang"
CLANG_GIT_URI = "git://git.ti.com/opencl/clang.git"
CLANG_GIT_PROTOCOL = "git"
CLANG_GIT_BRANCH = "release_36_ti"
CLANG_GIT_DESTSUFFIX = "${LLVM_GIT_DESTSUFFIX}/tools/clang"
CLANG_GIT_SRCREV = "1bffed84d31aa9271ef4c91301f833d103e94010"

SRC_URI = " \
  ${LLVM_GIT_URI};protocol=${LLVM_GIT_PROTOCOL};branch=${LLVM_GIT_BRANCH};destsuffix=${LLVM_GIT_DESTSUFFIX};name=${LLVM_GIT_NAME} \
  ${CLANG_GIT_URI};protocol=${CLANG_GIT_PROTOCOL};branch=${CLANG_GIT_BRANCH};destsuffix=${CLANG_GIT_DESTSUFFIX};name=${CLANG_GIT_NAME} \
  file://0001-configure-Do-not-check-build-executable-extension.patch \
"

SRCREV_${LLVM_GIT_NAME} = "${LLVM_GIT_SRCREV}"
SRCREV_${CLANG_GIT_NAME} = "${CLANG_GIT_SRCREV}"

S = "${WORKDIR}/git"

LIBXML2_INC = "`pkg-config libxml-2.0 --cflags`"
LIBXML2_LIBS = "`pkg-config libxml-2.0 --libs`"

EXTRA_OECONF += " --enable-targets="host,arm,c6000,msp430" \
                  --disable-zlib \
                  --disable-terminfo \
                  --disable-libedit \
"

EXTRA_OEMAKE += "LIBXML2_INC="${LIBXML2_INC}" LIBXML2_LIBS="${LIBXML2_LIBS}""

do_compile_class-native() {
  cd ${LLVM_BUILD_DIR}

  # Fix libdir for multilib
  sed -i 's:(PROJ_prefix)/lib:(PROJ_prefix)/${baselib}:g' Makefile.config

  oe_runmake
}

do_compile_class-nativesdk() {
    cd ${LLVM_BUILD_DIR}

    # Fix libdir for multilib
    sed -i 's:(PROJ_prefix)/lib:(PROJ_prefix)/${baselib}:g' Makefile.config

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

    # Workaround for timestamp issue on built-tools
    for f in ${LLVM_BUILD_DIR}/BuildTools/Release/bin/*
    do
        touch $f
    done

    oe_runmake
}

# Workaround for libdir fix for multilib
do_compile() {
    cd ${LLVM_BUILD_DIR}

    # Fix libdir for multilib
    sed -i 's:(PROJ_prefix)${base_libdir}:(PROJ_prefix)/${baselib}:g' Makefile.config

    oe_runmake \
        AR="${BUILD_AR}" \
        CC="${BUILD_CC}" \
        CFLAGS="${BUILD_CFLAGS}" \
        CXX="${BUILD_CXX}" \
        CXXFLAGS="${BUILD_CXXFLAGS}" \
        CPP="${BUILD_CPP}" \
        CPPFLAGS="${BUILD_CPPFLAGS}" \
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

INSANE_SKIP_${MLPREFIX}libllvm${LLVM_RELEASE}-llvm-${LLVM_RELEASE}.0 += "dev-so"

BBCLASSEXTEND = "native nativesdk"
