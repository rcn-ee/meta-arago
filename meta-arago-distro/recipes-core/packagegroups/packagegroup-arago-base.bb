DESCRIPTION = "Basic task to get a device booting"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r2"

inherit packagegroup

ARAGO_ALSA_BASE = "\
    alsa-lib \
    alsa-utils-aplay \
    "

ARAGO_BASE = "\
    module-init-tools \
    mtd-utils \
    curl \
    initscript-telnetd \
    ethtool \
    "

# these require meta-openembedded/meta-oe layer
ARAGO_EXTRA = "\
    devmem2 \
    tcpdump \
    "

# minimal set of packages - needed to boot
RDEPENDS_${PN} = "\
    ${ARAGO_ALSA_BASE} \
    ${ARAGO_BASE} \
    ${ARAGO_EXTRA} \
    "
