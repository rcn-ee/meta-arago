SUMMARY = "TI OpenMP-Acc example applications"

include openmpacc.inc

PR = "${INC_PR}.1"

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
    s = d.getVar("S")

    os.makedirs(s)
    shutil.copy(os.path.join(git_dir,"Makefile"),s)
    shutil.copy(os.path.join(git_dir,"make.inc"),s)
    shutil.copy(os.path.join(git_dir,"ompacc_env.sh"),s)
    for example in d.getVar("OMPACC_EXAMPLE_LIST").split():
        shutil.copytree(os.path.join(git_dir,example), os.path.join(s,example))
}

EXTRA_OEMAKE = " TARGET_ROOTDIR=${STAGING_DIR_HOST} \
                 TI_OCL_CGT_INSTALL=${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x \
"

MKFILELIST = "vecadd/Makefile vecadd_complex/Makefile dsplib_fft/Makefile \
null/Makefile dspheap/Makefile target_implicit_map/Makefile printf_debug/Makefile \
edmamgr/Makefile vecadd_t/Makefile target_orphan_call/Makefile target_update/Makefile \
edmabw/Makefile sub_section/Makefile vecadd_lib/Makefile local/Makefile"

do_configure() {
    sed "s|arm-linux-gnueabihf-gcc|${CC}|g" -i make.inc
    sed "s|arm-linux-gnueabihf-g++|${CXX}|g" -i make.inc
    for f in ${MKFILELIST}; do
        sed "s|-fopenmp|-fopenmp ${TUNE_CCARGS}${TOOLCHAIN_OPTIONS}|g" -i $f
    done
}

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
