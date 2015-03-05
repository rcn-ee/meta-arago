FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = "-arago0"

SRC_URI += "file://0001-Makefile-Add-TI-SDK-Modifications.patch"

EXTRA_OEMAKE = ""

do_compile () {
    unset CFLAGS
    unset LDFLAGS
    unset CPPFLAGS
    oe_runmake -C src
}
