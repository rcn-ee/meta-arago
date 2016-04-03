DESCRIPTION = "TI OpenMP-Acc example applications"

include openmpacc.inc

PR = "${INC_PR}.0"

DEPENDS = "openmpacc clacc-native clocl-native ti-cgt6x-native"
RDEPENDS_${PN} += "opencl-runtime"

S = "${WORKDIR}/git/openmpacc-examples-src"

OMPACC_EXAMPLE_LIST = " target_update \
                        vecadd \
                        printf_debug \
                        edmamgr \
                        dspheap \
                        target_orphan_call \
                        target_implicit_map \
                        vecadd_t \
                        vecadd_complex \
                        local \
                        null \
                        dsplib_fft \
                        vecadd_lib \
                        edmabw \
                        sub_section \
"

python do_unpack_append() {
    import shutil

    git_dir = d.expand("${WORKDIR}/git/examples")
    s = d.getVar("S", True)

    os.makedirs(s)
    shutil.copy(os.path.join(git_dir,"Makefile"),s)
    shutil.copy(os.path.join(git_dir,"make.inc"),s)
    shutil.copy(os.path.join(git_dir,"ompacc_env.sh"),s)
    for example in d.getVar("OMPACC_EXAMPLE_LIST", True).split():
        shutil.copytree(os.path.join(git_dir,example), os.path.join(s,example))
}

EXTRA_OEMAKE = " TARGET_ROOTDIR=${STAGING_DIR_HOST} \
                 TI_OCL_CGT_INSTALL=${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x \
"

do_compile() {
    oe_runmake
}

do_install() {
    install -d ${D}${datadir}/ti/examples/openmpacc

    install -m 644 ${B}/Makefile ${D}${datadir}/ti/examples/openmpacc
    install -m 644 ${B}/make.inc ${D}${datadir}/ti/examples/openmpacc
    install -m 644 ${B}/ompacc_env.sh ${D}${datadir}/ti/examples/openmpacc

    for ompacc_example in ${OMPACC_EXAMPLE_LIST}; do
        install -d ${D}${datadir}/ti/examples/openmpacc/${ompacc_example}
        cp -rv ${B}/${ompacc_example}/* ${D}${datadir}/ti/examples/openmpacc/${ompacc_example}
    done
}

FILES_${PN} += "\
    ${datadir}/ti/examples/openmpacc \
"

FILES_${PN}-dbg += "\
    ${datadir}/ti/examples/openmpacc/*/.debug \
"

INSANE_SKIP_${PN} = "arch ldflags textrel staticdev"
