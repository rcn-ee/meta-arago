SUMMARY = "UVC gadget userspace sample application"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://uvc-gadget.c;beginline=1;endline=18;md5=414860c3c534dc95d81da9564cfb8d2a"

SRC_URI = "git://git.ideasonboard.org/uvc-gadget.git"

PV = "1.1+git${SRCPV}"
SRCREV = "aa82df887ab995473cd83c89777cdf4bc4685dd0"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = 'CC="${CC}" CFLAGS="${CFLAGS}" LDFLAGS="${LDFLAGS}" KERNEL_INCLUDE=""'

do_compile () {
	oe_runmake
}

do_install () {
	install -d ${D}${bindir}
	install -m755 uvc-gadget ${D}${bindir}
}
