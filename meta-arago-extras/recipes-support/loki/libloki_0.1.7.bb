SUMMARY = "Loki C++ Library"
HOMEPAGE = "http://sourceforge.net/projects/loki-lib/"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://README;md5=5f7c1a2bebe34fc290234984d5845b03"

SRC_URI = "http://libloki.sourcearchive.com/downloads/${PV}-3/${PN}_${PV}.orig.tar.gz \
           file://0001-include-loki-Threads.h-return-statement-with-a-value.patch \
           file://0002-test-Function-FunctionTest.cpp-reference-to-bad_func.patch"

SRC_URI[md5sum] = "af532c24a7f2e12d0829be8201934d92"
SRC_URI[sha256sum] = "0c2094ce916b106731c8be61c32f538a22e1c0f8398bd5d6295b13d08e0c41a3"

S = "${WORKDIR}/${PN}-${PV}.orig"

do_configure () {
    sed -i -e 's|^prefix.*$|prefix := ${D}${prefix}|g' ${S}/Makefile.common
}

do_compile () {
    oe_runmake
}

do_install () {
    oe_runmake install
}
