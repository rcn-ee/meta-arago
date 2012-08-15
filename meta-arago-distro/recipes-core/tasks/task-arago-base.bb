DESCRIPTION = "Basic task to get a device booting"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r0"

inherit task

ARAGO_ALSA_BASE = "\
    alsa-lib \
    alsa-utils-aplay \
    "

ARAGO_BASE = "\
    ${ARAGO_ALSA_BASE} \
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
    base-files \
    base-passwd \
    busybox \
    initscripts \
    modutils-initscripts \
    netbase \
    update-alternatives \
    module-init-tools \
    ${ARAGO_BASE} \
    "
