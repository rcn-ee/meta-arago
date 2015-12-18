DESCRIPTION = "Prebuilt Keystone2 initramfs with SerDes and QMSS firmware"

LICENSE = "TI-TFL"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3a86335d32864b0bef996bee26cc0f2c"

PV = "0.0.1"
PR = "r0"

CLEANBROKEN = "1"

COMPATIBLE_MACHINE = "keystone"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "http://arago-project.org/files/releases/k2-fw/${P}.tar.gz"

SRC_URI[md5sum] = "086550a4303f75b6233a9b2ab4800acd"
SRC_URI[sha256sum] = "5db79d0f364d94d67ca85bc4d5ec35baaae7b39759fcab0dd0e049e2d12fb269"

S = "${WORKDIR}"
TARGET = "k2-fw-initrd.cpio.gz"

do_install() {
	install -d ${D}/boot
	install -m 0644 ${S}/${TARGET} ${D}/boot/${TARGET}
}

FILES_${PN} = "/boot"

inherit deploy

do_deploy () {
	install -d ${DEPLOYDIR}
	install -m 0644 ${S}/${TARGET} ${DEPLOYDIR}/${TARGET}
}

addtask deploy before do_build after do_compile
