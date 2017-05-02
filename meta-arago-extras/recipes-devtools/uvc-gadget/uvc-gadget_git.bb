SUMMARY = "UVC gadget userspace sample application"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://uvc-gadget.c;beginline=1;endline=18;md5=414860c3c534dc95d81da9564cfb8d2a"

DEPENDS = "virtual/kernel"

SRC_URI = "git://git.ideasonboard.org/uvc-gadget.git"
SRC_URI += "file://0001-uvc-gadget-don-t-hardcode-uvc.h-path.patch"

PV = "1.0+git${SRCPV}"
SRCREV = "3c5a666f9d2eea0e0f7e9a8a0eb8bbfd7687ca13"

S = "${WORKDIR}/git"

do_compile () {
	${CC} ${CFLAGS} -I${STAGING_KERNEL_DIR}/drivers/usb/gadget/function ${LDFLAGS} -o uvc-gadget uvc-gadget.c
}

do_install () {
	install -d ${D}${bindir}
	install -m755 uvc-gadget ${D}${bindir}
}
