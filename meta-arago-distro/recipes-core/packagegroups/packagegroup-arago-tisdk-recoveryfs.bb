DESCRIPTION = "Packagegroup for basic recovery rootfs"
LICENSE = "MIT"

inherit packagegroup

ARAGO_BASE = "\
    module-init-tools \
    mtd-utils \
    initscript-telnetd \
    "

ARAGO_EXTRA = "\
    makedumpfile \
    crash-recovery \
    "

# minimal set of packages - needed to boot
RDEPENDS_${PN} = "\
    ${ARAGO_BASE} \
    ${ARAGO_EXTRA} \
    "
