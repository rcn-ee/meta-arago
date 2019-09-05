SUMMARY = "Linux Kernel PCI test"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

BRANCH = "ti-linux-4.19.y"
SRCREV = "50ceb3c6e7f2d5f54d66d4999e79d3c4e09796df"
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
