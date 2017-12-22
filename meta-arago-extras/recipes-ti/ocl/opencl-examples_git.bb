SUMMARY = "TI OpenCL example applications"
HOMEPAGE = "http://software-dl.ti.com/mctools/docs/opencl/intro.html"
LICENSE = "BSD"

include ocl.inc
require recipes-ti/includes/ti-paths.inc

PR = "${INC_PR}.1"

COMPATIBLE_MACHINE = "dra7xx|keystone"
PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "opencl opencl-monitor ti-cgt6x-native clocl-native"

OCL_PERSISTENT_DEPENDS = "ti-xdctools-native ti-ipc-rtos ti-sysbios"

DEPENDS_append_dra7xx = " ${OCL_PERSISTENT_DEPENDS}"

RDEPENDS_${PN} += " opencl-runtime"
RDEPENDS_${PN}-dev += " libgomp-dev"

S = "${WORKDIR}/git/opencl_example_src"
B = "${S}"

OCL_EXAMPLE_LIST = " buffer \
                     ccode \
                     dsplib_fft \
                     float_compute \
                     null \
                     offline \
                     offline_embed \
                     platforms \
                     simple \
                     vecadd \
                     matmpy \
                     monte_carlo \
                     ooo_callback \
                     edmamgr \
                     sgemm \
                     vecadd_openmp \
                     vecadd_openmp_t \
                     dgemm \
                     abort_exit \
                     timeout \
"

OCL_PERSISTENT_EXAMPLE_LIST = " persistent_clock_concurrent \
                                persistent_clock_spanning \
                                persistent_common \
                                persistent_kernel_timeout \
                                persistent_messageq_concurrent \
                                persistent_task_concurrent \
                                persistent_task_spanning \
"

OCL_EXAMPLE_LIST_append_dra7xx = " ${OCL_PERSISTENT_EXAMPLE_LIST}"

python do_unpack_append() {
    import shutil

    git_dir = d.expand("${WORKDIR}/git/examples")
    s = d.getVar("S", True)

    os.makedirs(s)
    shutil.copy(os.path.join(git_dir,"Makefile"),s)
    shutil.copy(os.path.join(git_dir,"make.inc"),s)
    for example in d.getVar("OCL_EXAMPLE_LIST", True).split():
        shutil.copytree(os.path.join(git_dir,example), os.path.join(s,example))
}


EXTRA_OEMAKE = " TARGET_ROOTDIR=${STAGING_DIR_HOST} \
                 TI_OCL_CGT_INSTALL=${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x \
"

export XDC_DIR = "${XDC_INSTALL_DIR}/packages"
export IPC_DIR = "${IPC_INSTALL_DIR}/packages"
export BIOS_DIR = "${SYSBIOS_INSTALL_DIR}/packages"

do_install() {
    install -d ${D}${datadir}/ti/examples/opencl

    install ${B}/Makefile ${D}${datadir}/ti/examples/opencl
    install ${B}/make.inc ${D}${datadir}/ti/examples/opencl

    for ocl_example in ${OCL_EXAMPLE_LIST}; do
        install -d ${D}${datadir}/ti/examples/opencl/${ocl_example}
        cp -rv ${B}/${ocl_example}/* ${D}${datadir}/ti/examples/opencl/${ocl_example}
    done
}

FILES_${PN} += "\
    ${datadir}/ti/examples/opencl \
"

FILES_${PN}-dbg += "\
    ${datadir}/ti/examples/opencl/*/.debug \
"

INSANE_SKIP_${PN} = "arch ldflags textrel staticdev"
