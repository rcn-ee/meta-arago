DESCRIPTION = "TI Library Architecture"

include libarch.inc

PR = "${INC_PR}.0"

do_compile() {
    make -f build/Makefile TARGET=${TARGET} LIBOS=LIB_OPENCL
}

do_install() {
    install -d ${D}${LIBARCH_INSTALL_DIR_RECIPE}
    cp -r exports/libarch_*/* ${D}${LIBARCH_INSTALL_DIR_RECIPE}
}

FILES_${PN}-dev += "${LIBARCH_INSTALL_DIR_RECIPE}"

# skip checking binary against ARM architecture
INSANE_SKIP_${PN}-dev = "arch"
ALLOW_EMPTY_${PN} = "1"
