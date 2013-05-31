DESCRIPTION = "The calibrator and other useful utilities for TI wireless solution based on wl12xx driver"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=4725015cb0be7be389cf06deeae3683d"

DEPENDS = "libnl"
RDEPENDS = "ti-compat-wireless-wl12xx wl12xx-firmware"

PR ="r2+gitr${SRCPV}"

# Tag: ol_r8.a6.01
SRCREV = "214dfbdf97cc390b0020c4ea9331a1cf82240a64"
SRC_URI = "git://github.com/TI-OpenLink/18xx-ti-utils.git \
"

PROVIDES += "ti-wifi-utils"
RPROVIDES_${PN} += "ti-wifi-utils"
RREPLACES_${PN} +=  "ti-wifi-utils"
RCONFLICTS_${PN} +=  "ti-wifi-utils"

S = "${WORKDIR}/git"

export CROSS_COMPILE = "${TARGET_PREFIX}"
CFLAGS += " -DCONFIG_LIBNL20"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 calibrator ${D}${bindir}/
}
