DESCRIPTION = "TI Linear Algebra Library examples"

include linalg.inc
PR = "${INC_PR}.0"

DEPENDS += "linalg"
RDEPENDS_${PN} += "opencl-runtime"

export LINALG_DIR = "${LINALG_INSTALL_DIR}"

EXAMPLES_ROOT = "${WORKDIR}/git/examples/arm+dsp"

do_compile() {
    cd examples/arm+dsp
    make
    # Remove object files before installing so that the binaries are not present
    find . -name "*.obj" -type f -delete
    find . -name "*.o" -type f -delete
}

do_install() {
    install -d ${D}${datadir}/ti/examples/linalg
    cp -r examples/arm+dsp/* ${D}${datadir}/ti/examples/linalg
}

FILES_${PN} += "\
    ${datadir}/ti/examples/linalg/* \
"

FILES_${PN}-dbg += "\
    ${datadir}/ti/examples/linalg/*/.debug \
"

INSANE_SKIP_${PN} = "arch ldflags textrel"
