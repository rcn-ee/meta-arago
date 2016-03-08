DESCRIPTION = "Libnl extension for XFRM support"
PROVIDES = "libnl-xfrm"
SECTION = "net"
LICENSE = "BSD-3-Clause"

COMPATIBLE_MACHINE = "keystone"

LIC_FILES_CHKSUM = "file://include/xfrm_pvt.h;beginline=1;endline=33;md5=fe068af290f274f2a86a867bbd7cc61c"

DEPENDS = "libnl"

BRANCH="hawking_dev"
# The following commit correspond to DEV.LIBNL-XFRM.03.01.00.00A
SRCREV = "2a5ee7c4f41398c07c593e81af7b71c7720e6de8"
SRC_URI = "git://arago-project.org/git/projects/libnl-xfrm.git;protocol=git;branch=${BRANCH}"

PR = "r1"

S = "${WORKDIR}/git"

LIBNL_XFRM_LIB = "lib/libnl-xfrm.a"

CFLAGS += "-I${STAGING_INCDIR} -I${STAGING_INCDIR}/libnl3 -fPIC -DPIC "

do_compile() {
	mkdir -p ${S}/lib
	make clean
	make all
}

do_install_append() {
	install -d ${D}${libdir}/
	install -d ${D}${includedir}/
	install -d ${D}${includedir}/libnl3/netlink/
	install -d ${D}${includedir}/libnl3/netlink/xfrm/
	install -c -m 755 ${S}/${LIBNL_XFRM_LIB} ${D}${libdir}/
	install -c -m 755 ${S}/include/netlink/xfrm/*.h ${D}${includedir}/libnl3/netlink/xfrm/
	install -c -m 755 ${S}/lib/libnl-xfrm.so ${D}${libdir}/libnl-xfrm.so.1.0.0
	cd ${D}${includedir}/
	ln -s libnl3/netlink netlink
	cd ${D}${libdir}/
	ln -s libnl-xfrm.so.1.0.0 libnl-xfrm.so.1
	ln -s libnl-xfrm.so.1.0.0 libnl-xfrm.so
}
