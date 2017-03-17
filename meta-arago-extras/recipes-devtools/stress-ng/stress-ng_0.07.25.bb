SUMMARY = "A tool to load and stress a computer system"
HOMEPAGE = "http://kernel.ubuntu.com/~cking/stress-ng/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "zlib libaio"

SRC_URI = "http://kernel.ubuntu.com/~cking/tarballs/${BPN}/${BP}.tar.gz"

SRC_URI[md5sum] = "cc2cecc81ff367976b3dbb68e9959cfd"
SRC_URI[sha256sum] = "9143c1e78c92612c6a58913c2035c0039e1fe9ff72f99148f049abe47c167224"

CFLAGS += "-Wall -Wextra -DVERSION='"$(VERSION)"' -O2"

do_install() {
	oe_runmake DESTDIR=${D} install
}
