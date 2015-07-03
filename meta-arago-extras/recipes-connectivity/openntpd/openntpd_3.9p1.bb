DESCRIPTION = "OpenNTPD is a FREE, easy to use implementation of the \
Network Time Protocol."
HOMEPAGE = "http://www.openntpd.org/"
SECTION = "console/network"
LICENSE = "BSD & ISC"
LIC_FILES_CHKSUM = "file://LICENCE;md5=4b4f5158007cc97e6b0e2325bb99854a"

PR = "r0"

SRC_URI = "http://mirror.ece.vt.edu/pub/OpenBSD/OpenNTPD/${P}.tar.gz"

S = "${WORKDIR}/openntpd-${PV}"
EXTRA_OECONF = "--disable-strip"
inherit autotools

LDFLAGS += "-lrt"
EXTRA_OECONF += "LDFLAGS="${LDFLAGS}" CFLAGS="${CFLAGS}"\
                 --with-privsep-user=root --with-privsep-path=/${prefix}"

SRC_URI[md5sum] = "afc34175f38d08867c1403d9008600b3"
SRC_URI[sha256sum] = "83dd7c1e8ec8b4567afe49af539271b5a73562fb7a3ca51df73eccba89ec8c49"
