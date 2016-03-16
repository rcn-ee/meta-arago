DESCRIPTION = "TI Linear Algebra Library examples"

include linalg.inc
PR = "${INC_PR}.0"

DEPENDS += "linalg"
RDEPENDS_${PN} += "opencl-runtime"

export LINALG_DIR = "${LINALG_INSTALL_DIR}"

EXAMPLES_ROOT = "${WORKDIR}/git/linalg_example_src"
B = "${S}"

LINALG_EXAMPLE_LIST = "dgemm_test \
                       dsyrk_test \
                       eig \
                       gemm_bench \
                       ludinv \
                       matmpy \
                       ztrmm_test \
                       ztrsm_test \
"

python do_unpack_append() {
    import shutil

    git_dir = d.expand("${WORKDIR}/git/examples/arm+dsp")
    s = d.getVar("EXAMPLES_ROOT", True)

    os.makedirs(s)
    shutil.copy(os.path.join(git_dir,"Makefile"),s)
    shutil.copy(os.path.join(git_dir,"make.inc"),s)
    shutil.copy(os.path.join(git_dir,"run_tests_evm.sh"),s)
    for example in d.getVar("LINALG_EXAMPLE_LIST").split():
        shutil.copytree(os.path.join(git_dir,example), os.path.join(s,example))
}

EXTRA_OEMAKE = " TARGET_ROOTDIR=${STAGING_DIR_HOST} TI_OCL_CGT_INSTALL=${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x"

do_compile() {
    cd ${EXAMPLES_ROOT}
    oe_runmake
    # Remove object files before installing so that the binaries are not present
    find . -name "*.obj" -type f -delete
    find . -name "*.o" -type f -delete
}

do_install() {
    install -d ${D}${datadir}/ti/examples/linalg

    install ${EXAMPLES_ROOT}/Makefile ${D}${datadir}/ti/examples/linalg
    install ${EXAMPLES_ROOT}/make.inc ${D}${datadir}/ti/examples/linalg
    install ${EXAMPLES_ROOT}/run_tests_evm.sh ${D}${datadir}/ti/examples/linalg

    cd ${EXAMPLES_ROOT}
    for linalg_example in ${LINALG_EXAMPLE_LIST}; do
        install -d ${D}${datadir}/ti/examples/linalg/${linalg_example}
        cp -rv ${EXAMPLES_ROOT}/${linalg_example}/. ${D}${datadir}/ti/examples/linalg/${linalg_example}
    done
}

FILES_${PN} += "\
    ${datadir}/ti/examples/linalg/* \
"

FILES_${PN}-dbg += "\
    ${datadir}/ti/examples/linalg/*/.debug \
"

INSANE_SKIP_${PN} = "arch ldflags textrel"

CREATE_SRCIPK = "1"
SRCIPK_INSTALL_DIR = "example-applications/${PN}-${PV}"
SRCIPK_SRC_DIR = "${EXAMPLES_ROOT}"
