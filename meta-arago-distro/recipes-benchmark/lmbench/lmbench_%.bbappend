FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DEPENDS += "libtirpc"

INSANE_SKIP_${PN} += "ldflags"

PR_append = ".arago3"

SRC_URI += "file://0001-Makefile-Add-TI-SDK-Modifications.patch"

EXTRA_OEMAKE = ""
CFLAGS = "-I${STAGING_INCDIR}/tirpc"
LDFLAGS = "-ltirpc"

do_compile () {
    oe_runmake -C src
}

do_install_append() {
    rm -rf ${D}${datadir}
}

RDEPENDS_${PN}_remove = "perl"
