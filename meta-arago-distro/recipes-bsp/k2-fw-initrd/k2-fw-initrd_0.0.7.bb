DESCRIPTION = "Prebuilt Keystone2 initramfs with SerDes, QMSS and NETCP PA firmware"

LICENSE = "TI-TFL"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c5e02be633f1499c109d1652514d85ec"

CLEANBROKEN = "1"

COMPATIBLE_MACHINE = "keystone"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "http://arago-project.org/files/releases/k2-fw/k2-initramfs-${PV}.tar.gz"

SRC_URI[md5sum] = "27fb248cbfe08ed8344bdc4451067c8f"
SRC_URI[sha256sum] = "beb19d685ee0d20281266726e4c2ba4b245af9450c1bd5155ff06d8c1656dd26"

S = "${WORKDIR}"
TARGET = "k2-fw-initrd.cpio.gz"
TARGETM = "k2-fw-initrd-${MACHINE}.cpio.gz"

do_install() {
	install -d ${D}/boot
	install -m 0644 ${S}/${TARGET} ${D}/boot/${TARGETM}
	ln -s ${TARGETM} ${D}/boot/${TARGET}
}

FILES_${PN} = "/boot"

inherit deploy

do_deploy() {
	install -d ${DEPLOYDIR}
	install -m 0644 ${S}/${TARGET} ${DEPLOYDIR}/${TARGETM}
	ln -s ${TARGETM} ${DEPLOYDIR}/${TARGET}
}

addtask deploy before do_build after do_compile

do_image_complete() {
	:
}

addtask image_complete after do_deploy before do_build
