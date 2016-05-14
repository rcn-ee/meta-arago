PR_append = ".arago0"

do_install_append() {
    install -d ${D}/${base_libdir}
    ln -sf libudev.so.1 ${D}${base_libdir}/libudev.so.0
}
