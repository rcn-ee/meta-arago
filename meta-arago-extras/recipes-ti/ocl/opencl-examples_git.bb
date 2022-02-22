SUMMARY = "TI OpenCL example applications"
HOMEPAGE = "https://downloads.ti.com/mctools/esd/docs/opencl/index.html"
LICENSE = "BSD-3-Clause"

include ocl.inc
require recipes-ti/includes/ti-paths.inc

PR = "${INC_PR}.1"

COMPATIBLE_MACHINE = "dra7xx"
PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "opencl opencl-monitor ti-cgt6x-native clocl-native"

OCL_PERSISTENT_DEPENDS = "ti-xdctools-native ti-ipc-rtos ti-sysbios"

DEPENDS:append:dra7xx = " ${OCL_PERSISTENT_DEPENDS}"

# Split examples into two groups:
# - offline-compile: examples who's kernels are precompiled (offline).
# - runtime-compile: examples who's kernels are compiled during runtime.
PACKAGES =+ "${PN}-runtime-compile ${PN}-runtime-compile-dbg ${PN}-offline-compile ${PN}-offline-compile-dbg"

RDEPENDS:${PN} = "${PN}-runtime-compile ${PN}-offline-compile"
RDEPENDS:${PN}-dev += "libgomp-dev"
RDEPENDS:${PN}-offline-compile += "opencl-runtime"
RDEPENDS:${PN}-runtime-compile += "opencl"

S = "${WORKDIR}/git/opencl_example_src"
B = "${S}"

OCL_RUNTIME_COMPILE_EXAMPLE_LIST = " \
    ccode \
    null \
    ooo_callback \
    simple \
    vecadd \
    vecadd_openmp \
    vecadd_openmp_t \
    vecadd_subdevice \
"

OCL_EXAMPLE_LIST = " abort_exit \
                     buffer \
                     ccode \
                     conv1d \
                     dgemm \
                     dspheap \
                     dsplib_fft \
                     edmamgr \
                     float_compute \
                     matmpy \
                     monte_carlo \
                     null \
                     offline \
                     offline_embed \
                     ooo_callback \
                     platforms \
                     sgemm \
                     simple \
                     timeout \
                     vecadd \
                     vecadd_openmp \
                     vecadd_openmp_t \
                     vecadd_subdevice \
"

OCL_PERSISTENT_EXAMPLE_LIST = " persistent_clock_concurrent \
                                persistent_clock_spanning \
                                persistent_common \
                                persistent_kernel_timeout \
                                persistent_messageq_concurrent \
                                persistent_task_concurrent \
                                persistent_task_spanning \
"

OCL_EXAMPLE_LIST:append:dra7xx = " ${OCL_PERSISTENT_EXAMPLE_LIST}"

OCL_MPAX_EXAMPLE_LIST = " vecadd_mpax \
                          vecadd_mpax_openmp \
"

python do_unpack:append() {
    s = d.getVar("S")
    os.makedirs(s)
}

python do_patch:append() {
    import shutil
    git_dir = d.expand("${WORKDIR}/git/examples")
    s = d.getVar("S")
    shutil.copy(os.path.join(git_dir,"Makefile"),s)
    shutil.copy(os.path.join(git_dir,"make.inc"),s)
    for example in d.getVar("OCL_EXAMPLE_LIST").split():
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

# First package the examples which require run-time kernel compilation.
FILES:${PN}-runtime-compile += "\
    ${@' '.join(['${datadir}/ti/examples/opencl/' + example for example in d.getVar('OCL_RUNTIME_COMPILE_EXAMPLE_LIST').split()])} \
"

FILES:${PN}-runtime-compile-dbg += "\
    ${@' '.join(['${datadir}/ti/examples/opencl/' + example + '/.debug' for example in d.getVar('OCL_RUNTIME_COMPILE_EXAMPLE_LIST').split()])} \
"

# Remaining examples will fall through to the "offline" package.
FILES:${PN}-offline-compile += "\
    ${datadir}/ti/examples/opencl/ \
"

FILES:${PN}-offline-compile-dbg += "\
    ${datadir}/ti/examples/opencl/*/.debug \
"

# Add makefiles to dev package
FILES:${PN}-dev = "${datadir}/ti/examples/opencl/Makefile \
                   ${datadir}/ti/examples/opencl/make.inc"

ALLOW_EMPTY:${PN} = "1"
INSANE_SKIP:${PN} = "arch ldflags textrel staticdev"
INSANE_SKIP:${PN}-offline-compile = "arch ldflags textrel staticdev"
INSANE_SKIP:${PN}-runtime-compile = "arch ldflags textrel staticdev"
