DESCRIPTION = "The calibrator and other useful utilities for TI wireless solution based on wl12xx driver"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=4725015cb0be7be389cf06deeae3683d"

DEPENDS = "libnl"

PR ="r0+gitr${SRCPV}"
PV ="0.0"

SRCREV = "ol_R5.00.18"
SRC_URI = "git://github.com/TI-OpenLink/ti-utils.git;protocol=git"

S = "${WORKDIR}/git"

export CROSS_COMPILE = "${TARGET_PREFIX}"
CFLAGS += " -DCONFIG_LIBNL20"

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${datadir}/ti/wifi-utils/ini_files/127x
	install -d ${D}${datadir}/ti/wifi-utils/ini_files/128x

	install -m 0755 calibrator ${D}${bindir}/
	install -m 0755 ${S}/hw/ini_files/127x/* ${D}${datadir}/ti/wifi-utils/ini_files/127x
	install -m 0755 ${S}/hw/ini_files/128x/* ${D}${datadir}/ti/wifi-utils/ini_files/128x
}

FILES_${PN} += " \
	${datadir}/ti/wifi-utils/ini_files/127x \
	${datadir}/ti/wifi-utils/ini_files/128x \
"
