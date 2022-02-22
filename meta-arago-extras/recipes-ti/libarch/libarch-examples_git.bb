DESCRIPTION = "TI Library Architecture Examples"

include libarch.inc

PR = "${INC_PR}.0"

DEPENDS += "libarch clocl-native"
RDEPENDS:${PN} += "opencl-runtime"

export LIBARCH_DIR    = "${LIBARCH_INSTALL_DIR}"
export TARGET_ROOTDIR = "${STAGING_DIR_TARGET}"

do_compile() {
    cd examples
    make TARGET=${TARGET} LIBOS=LIB_OPENCL
    # Remove object files before installing so that the binaries are not present
    find . -name "*.obj" -type f -delete
    find . -name "*.o" -type f -delete
    find . -name "*.out" -type f -delete
    find . -name "*.dsp_h" -type f -delete
}

do_install() {
    install -d ${D}${datadir}/ti/examples/libarch
    cp -r examples/arm+dsp ${D}${datadir}/ti/examples/libarch
    cp -r examples/common ${D}${datadir}/ti/examples/libarch
    cp examples/Makefile ${D}${datadir}/ti/examples/libarch
}

FILES:${PN} += "\
    ${datadir}/ti/examples/libarch/* \ "

FILES:${PN}-dbg += "\
    ${datadir}/ti/examples/libarch/*/.debug \ "

INSANE_SKIP:${PN} = "arch ldflags textrel"
