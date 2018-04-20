SUMMARY = "TI OpenCL example applications"
HOMEPAGE = "http://software-dl.ti.com/mctools/docs/opencl/intro.html"
LICENSE = "BSD"

require recipes-ti/ocl/ocl.inc
require recipes-ti/includes/arago-paths.inc

PR = "${INC_PR}.1"

COMPATIBLE_MACHINE = "omap-a15"
PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "opencl-rtos ti-cgt6x-native clocl-rtos-native opencl-monitor-rtos \
           clocl-win gcc-arm-none-eabi-native ti-xdctools-native ti-sysbios \
"

S = "${WORKDIR}/git/opencl_example_src"
B = "${S}"

OCL_EXAMPLE_LIST = " abort_exit \
                     buffer \
                     ccode \
                     dsplib_fft \
                     float_compute \
                     null \
                     offline_embed \
                     platforms \
                     simple \
                     timeout \
                     vecadd \
                     matmpy \
                     ooo_callback \
                     sgemm \
                     edmamgr \
                     vecadd_openmp \
                     vecadd_openmp_t \
"

RELEASE_TARGET = ""
RELEASE_TARGET_omap-a15 = "am57xx"

export BIOS_INSTALL_DIR = "${SYSBIOS_INSTALL_DIR}"
export DESTDIR="${OCL_RTOS_INSTALL_DIR}/ti-opencl-rtos-${RELEASE_TARGET}-${PV}"
export TI_OCL_INSTALL = "${DESTDIR}/packages/ti/opencl"

python do_unpack_append() {
    import shutil

    git_dir = d.expand("${WORKDIR}/git/examples")
    s = d.getVar("S", True)

    os.makedirs(s)
    shutil.copy(os.path.join(git_dir,"Makefile"),s)
    shutil.copy(os.path.join(git_dir,"make_rtos.inc"),s)
    shutil.copy(os.path.join(git_dir,"rtos_main.c"),s)
    shutil.copy(os.path.join(git_dir,"load_am57_rtos.js"),s)
    for example in d.getVar("OCL_EXAMPLE_LIST", True).split():
        shutil.copytree(os.path.join(git_dir,example), os.path.join(s,example))
}

EXTRA_OEMAKE = "BUILD_OS=SYS_BIOS \
                TI_OCL_CGT_INSTALL=${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x \
"

do_compile() {
    unset LDFLAGS
    unset TARGET_LDFLAGS

    oe_runmake CLOCL=${STAGING_DIR_NATIVE}/usr/share/ti/ti-opencl-rtos-tree/bin/x86/clocl
}

do_install() {
    install -d ${DESTDIR}/examples

    install ${B}/Makefile ${DESTDIR}/examples
    install ${B}/make_rtos.inc ${DESTDIR}/examples
    install ${B}/rtos_main.c ${DESTDIR}/examples

    for ocl_example in ${OCL_EXAMPLE_LIST}; do
        install -d ${DESTDIR}/examples/${ocl_example}
        cp -rv ${B}/${ocl_example}/* ${DESTDIR}/examples/${ocl_example}
    done
}
