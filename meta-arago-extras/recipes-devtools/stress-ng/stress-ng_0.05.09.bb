SUMMARY = "A tool to load and stress a computer system"
HOMEPAGE = "http://kernel.ubuntu.com/~cking/stress-ng/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "http://kernel.ubuntu.com/~cking/tarballs/${BPN}/${BP}.tar.gz"

SRC_URI[md5sum] = "fe65047991f654ffaac3c59ea9537763"
SRC_URI[sha256sum] = "d785b5f2df042d42c43ddfd5bbafa19151ed96f0c483d7f44c737f492b52ddd6"

CFLAGS += "-Wall -Wextra -DVERSION='"$(VERSION)"' -O2"

do_install() {
	oe_runmake DESTDIR=${D} install
}
