SUMMARY = "Linux Kernel PCI test"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

BRANCH = "ti-lsk-linux-4.9.y"
SRCREV = "b4aa954ead9260eaf7138755fc9d062a9f4630eb"
SRC_URI = "git://git.ti.com/ti-linux-kernel/ti-linux-kernel.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

do_compile () {
	cd ${S}/tools/pci
	${CC} ${CFLAGS} ${LDFLAGS} -o pcitest pcitest.c
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ${S}/tools/pci/pcitest ${D}${bindir}
	install -m 0755 ${S}/tools/pci/pcitest.sh ${D}${bindir}
}
