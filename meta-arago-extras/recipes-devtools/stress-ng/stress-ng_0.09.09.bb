SUMMARY = "A tool to load and stress a computer system"
HOMEPAGE = "http://kernel.ubuntu.com/~cking/stress-ng/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "zlib libaio"

SRC_URI = "http://kernel.ubuntu.com/~cking/tarballs/${BPN}/${BP}.tar.xz"

SRC_URI[md5sum] = "6e4df71095e780654ccc0a713b8423fe"
SRC_URI[sha256sum] = "e993fddb1d990a0cdb23b2af6cf6c417a1c09e155ada7c558ad80eae8a5feed3"

CFLAGS += "-Wall -Wextra -DVERSION='"$(VERSION)"' -O2"

do_install() {
	oe_runmake DESTDIR=${D} install
	chown -R root:root ${D}
}
