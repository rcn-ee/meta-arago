SUMMARY = "IPSec Manager libraries"
DESCRIPTION = "Provides library to offload IPSec security policy & associated security association to NETCP for crypto operations"

LIC_FILES_CHKSUM = "file://../ipsecmgr_snoop.h;beginline=1;endline=33;md5=f7eadca4fb5599f508dc11fa1e752919"

include ipsecmgr.inc

PR = "r2"

DEPENDS = "libnl-xfrm"
RDEPENDS_${PN} = "ipsecmgr-mod"

CFLAGS += "-I${STAGING_INCDIR}/libnl3"

S = "${WORKDIR}/git/build"
LIB_INC_DIR = "${WORKDIR}/git"
UTILS_LIB_INC_DIR = "${WORKDIR}/git/utils/iface/"

ALLOW_EMPTY_${PN} = "1"

do_compile() {
# Compile the library
	make clean
	make all
}
do_install() {
# Install libraries
	install -d ${D}${libdir}/
	install -c -m 666 libipsecmgr_snoop.a ${D}${libdir}/
	install -c -m 666 libipsecmgr_ipc.a ${D}${libdir}/
	install -c -m 666 libipsecmgr_syslog.a ${D}${libdir}/
	install -d ${D}${includedir}/
	install -c -m 666 ${LIB_INC_DIR}/*.h ${D}${includedir}/
	install -c -m 666 ${UTILS_LIB_INC_DIR}/*.h ${D}${includedir}/
}
