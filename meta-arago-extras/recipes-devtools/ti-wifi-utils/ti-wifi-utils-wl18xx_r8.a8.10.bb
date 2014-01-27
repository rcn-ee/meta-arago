DESCRIPTION = "The calibrator and other useful utilities for TI wireless solution based on wl12xx driver"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=4725015cb0be7be389cf06deeae3683d"

DEPENDS = "libnl"
RDEPENDS_${PN} = "wl18xx-firmware"

PR ="r1+gitr${SRCPV}"

#Tag: ol_r8.a8.10
SRCREV = "c50159d66af1786414b819ebcaa8b2571ae790a1"
SRC_URI = "git://github.com/TI-OpenLink/18xx-ti-utils.git \
"

PROVIDES += "ti-wifi-utils"
RPROVIDES_${PN} += "ti-wifi-utils"
RREPLACES_${PN} +=  "ti-wifi-utils"
RCONFLICTS_${PN} +=  "ti-wifi-utils"

S = "${WORKDIR}/git"

export CROSS_COMPILE = "${TARGET_PREFIX}"

EXTRA_OEMAKE = 'CFLAGS="${CFLAGS} -I${STAGING_INCDIR}/libnl3/ -DCONFIG_LIBNL32 " \
		LDFLAGS="${LDFLAGS} -L${STAGING_LIBDIR}" \
		NLVER=3'

do_install() {
    install -d ${D}${bindir}
    install -m 0755 calibrator ${D}${bindir}/
}
