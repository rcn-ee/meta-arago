DESCRIPTION = "TI Library Architecture"

include libarch.inc

PR = "${INC_PR}.0"

do_compile() {
    make lib TARGET=${TARGET} LIBOS=LIB_OPENCL
    make docs

    # Delete .obj files before installing
    rm src/*.obj
}

do_install() {
    install -d ${D}${LIBARCH_INSTALL_DIR_RECIPE}
    cp -r docs lib include src ${D}${LIBARCH_INSTALL_DIR_RECIPE}
    cp Makefile ${D}${LIBARCH_INSTALL_DIR_RECIPE}
}

FILES_${PN}-dev += "${LIBARCH_INSTALL_DIR_RECIPE}"

# skip checking binary against ARM architecture
INSANE_SKIP_${PN}-dev = "arch"
ALLOW_EMPTY_${PN} = "1"
