DESCRIPTION = "The calibrator and other useful utilities for TI wireless solution based on wl12xx driver"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=4725015cb0be7be389cf06deeae3683d"

DEPENDS = "libnl"
RDEPENDS = "ti-compat-wireless-wl12xx wl12xx-firmware"

inherit update-rc.d
INITSCRIPT_NAME="calibrate.sh"

PR ="r1+gitr${SRCPV}"
PV ="0.0"

SRCREV = "ol_R5.SP3.05"
SRC_URI = "git://github.com/TI-OpenLink/ti-utils.git;protocol=git \
           file://calibrate.sh \
"

S = "${WORKDIR}/git"

export CROSS_COMPILE = "${TARGET_PREFIX}"
CFLAGS += " -DCONFIG_LIBNL20"

do_install() {
    install -d ${D}${bindir}
    install -d ${D}${datadir}/ti/wifi-utils/ini_files/127x
    install -d ${D}${datadir}/ti/wifi-utils/ini_files/128x
    install -d ${D}${sysconfdir}/init.d

    install -m 0755 calibrator ${D}${bindir}/
    install -m 0755 ${S}/hw/ini_files/127x/* ${D}${datadir}/ti/wifi-utils/ini_files/127x
    install -m 0755 ${S}/hw/ini_files/128x/* ${D}${datadir}/ti/wifi-utils/ini_files/128x
    install -m 0755 ${WORKDIR}/calibrate.sh ${D}${sysconfdir}/init.d
}

FILES_${PN} += " \
    ${datadir}/ti/wifi-utils/ini_files/127x \
    ${datadir}/ti/wifi-utils/ini_files/128x \
"
