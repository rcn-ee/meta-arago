SUMMARY = "Linux Kernel timestamping"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

SRC_URI = "https://www.kernel.org/pub/linux/kernel/v4.x/linux-${PV}.tar.xz"

SRC_URI[md5sum] = "fe9dc0f6729f36400ea81aa41d614c37"
SRC_URI[sha256sum] = "caf51f085aac1e1cea4d00dbbf3093ead07b551fc07b31b2a989c05f8ea72d9f"

S = "${WORKDIR}/linux-${PV}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_compile () {
	cd ${S}/Documentation/networking/timestamping
	${CC} -o timestamping timestamping.c
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ${S}/Documentation/networking/timestamping/timestamping ${D}${bindir}
}

INSANE_SKIP_${PN} = "ldflags"
