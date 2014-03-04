DESCRIPTION = "This software is an implementation of the Precision Time Protocol (PTP) \
according to IEEE standard 1588 for Linux"
HOMEPAGE = "http://linuxptp.sourceforge.net/"
SECTION = "console/network"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
PR = "r0"

SRC_URI = "http://iweb.dl.sourceforge.net/project/linuxptp/v${PV}/linuxptp-${PV}.tgz"
SRC_URI[md5sum] = "664706a86fe1413391d4536080548501"
SRC_URI[sha256sum] = "b1651186689ef06e56add506bd9bb55a700ca56e3f92ba71d08f3ad12fad3085"

EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX} ARCH=${TARGET_ARCH} \
		EXTRA_CFLAGS="-D_GNU_SOURCE -DHAVE_CLOCK_ADJTIME \
		-DHAVE_ONESTEP_SYNC""

do_install() {
	install -d ${D}${bindir}/
	install -c -m 755 ${S}/ptp4l ${D}${bindir}/
}
