DESCRIPTION = "Basic task to get a device booting"
LICENSE = "MIT"
PR = "r5"

inherit packagegroup

ARAGO_ALSA_BASE = "\
    alsa-lib \
    alsa-utils-aplay \
    "

ARAGO_BASE = "\
    module-init-tools \
    mtd-utils \
    mtd-utils-ubifs \
    curl \
    initscript-telnetd \
    ethtool \
    thermal-init \
    "

# these require meta-openembedded/meta-oe layer
ARAGO_EXTRA = "\
    devmem2 \
    tcpdump \
    "

# minimal set of packages - needed to boot
RDEPENDS_${PN} = "\
    ${@base_contains('MACHINE_FEATURES', 'alsa', '${ARAGO_ALSA_BASE}', '',d)} \
    ${ARAGO_BASE} \
    ${ARAGO_EXTRA} \
    "
