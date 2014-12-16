DESCRIPTION = "The Linux Kernel Stream Control Transmission Protocol (lksctp) project"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=0c56db0143f4f80c369ee3af7425af6e"

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/lksctp/lksctp-tools-${PV}.tar.gz"

SRC_URI[md5sum] = "708bb0b5a6806ad6e8d13c55b067518e"
SRC_URI[sha256sum] = "0903dd526b7f30a89d5031aa2c82757612becc38ed7bc6e4f972f8deae351f26"

BBCLASSEXTEND = "native"

inherit autotools pkgconfig binconfig

RREPLACES_${PN} = "lksctp"

PACKAGES =+ "${PN}-withsctp ${PN}-utils"

FILES_${PN} = "${libexecdir}/* ${libdir}/lib*${SOLIBS} \
            ${sysconfdir} ${sharedstatedir} ${localstatedir} \
            ${base_libdir}/*${SOLIBS}"

FILES_${PN}-withsctp = "${libdir}/lksctp-tools/lib*${SOLIBS}"

FILES_${PN}-dev += " \
  ${datadir}/lksctp-tools/checksctp.c \
  ${datadir}/lksctp-tools/sctp_socket.c \
  ${datadir}/lksctp-tools/sctp_bind.c \
  ${datadir}/lksctp-tools/sctp_darn.c \
  ${datadir}/lksctp-tools/sctp_load_libs.c \
  ${datadir}/lksctp-tools/sctp_sockopt.c \
  ${datadir}/lksctp-tools/sctp_socket.h \
  ${datadir}/lksctp-tools/sctp_test.c \
  ${datadir}/lksctp-tools/sctp_darn.h \
  ${datadir}/lksctp-tools/sctp_status.c \
  ${libdir}/lksctp-tools/lib*.so"

FILES_${PN}-utils = " \
  ${bindir}/sctp_test \
  ${bindir}/sctp_darn \
  ${bindir}/checksctp \
  ${bindir}/withsctp \
  ${bindir}/sctp_status"
