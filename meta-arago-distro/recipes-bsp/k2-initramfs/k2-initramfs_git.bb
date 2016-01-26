DESCRIPTION = "Prebuilt Keystone2 initramfs with SerDes and QMSS firmware"

LICENSE = "TI-TFL"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3a86335d32864b0bef996bee26cc0f2c"

PV = "0.0.2"
PR = "r0"

CLEANBROKEN = "1"

COMPATIBLE_MACHINE = "keystone"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "http://arago-project.org/files/releases/k2-fw/${P}.tar.gz"

SRC_URI[md5sum] = "6f64aef93b0132ca1cdaf65cfed9d41b"
SRC_URI[sha256sum] = "2748bccb2b589054157b349cd726f4f6edcd89104eb3a8c3d0d0d672e2e34a0e"

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
