require posix-smp-demo.inc

PR = "${INC_PR}.0"

EXTRA_OEMAKE = "-f Makefile_linux EGCC="${CC}""

do_compile() {
    oe_runmake posix-smp-demo-linux-armv7
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 posix-smp-demo-linux-armv7 ${D}${bindir}
}
