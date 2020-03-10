SUMMARY = "Linux Kernel PCI test"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

BRANCH = "ti-linux-5.4.y"
SRCREV = "738552d0b0292e148b35d60ec47ca3c8dd6007b4"
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
