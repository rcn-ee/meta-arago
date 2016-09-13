DESCRIPTION = "Prebuilt Keystone2 initramfs with SerDes, QMSS and NETCP PA firmware"

LICENSE = "TI-TFL"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c5e02be633f1499c109d1652514d85ec"

PV = "0.0.6"
PR = "r0"

CLEANBROKEN = "1"

COMPATIBLE_MACHINE = "keystone"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "http://arago-project.org/files/releases/k2-fw/${P}.tar.gz"

SRC_URI[md5sum] = "1a4052bdb659de4180c7e71271fe0451"
SRC_URI[sha256sum] = "0af426ec1bdbf59f9ad4a84d6df123300f0d921feb74d4f1de701b9a0fa1ca76"

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
