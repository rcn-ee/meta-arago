DESCRIPTION = "Prebuilt Keystone2 initramfs with SerDes, QMSS and NETCP PA firmware"

LICENSE = "TI-TFL"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3a86335d32864b0bef996bee26cc0f2c"

PV = "0.0.4"
PR = "r0"

CLEANBROKEN = "1"

COMPATIBLE_MACHINE = "keystone"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "http://arago-project.org/files/releases/k2-fw/${P}.tar.gz"

SRC_URI[md5sum] = "ba1fe7a7f9279ea7ed0d26fbba30e4d5"
SRC_URI[sha256sum] = "c76c0899cbe9b5dde45febf4be48175142dc49ddcfe759596090c183743e8b3b"

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
