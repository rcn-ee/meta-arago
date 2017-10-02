DESCRIPTION = "Extended task to get more basic and console apps"
LICENSE = "MIT"
PR = "r14"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

# alsa-utils-alsamixer depends on ncurses
ARAGO_ALSA_EXTRA = "\
    alsa-conf \
    alsa-conf-base \
    alsa-server \
    alsa-utils \
    alsa-utils-aconnect \
    alsa-utils-scripts \
    alsa-utils-alsactl \
    alsa-utils-alsamixer \
    alsa-utils-amixer \
    alsa-utils-iecset \
    alsa-utils-midi \
    alsa-utils-speakertest \
    alsa-state \
    "

ARAGO_TSLIB = "\
    tslib-conf \
    tslib-calibrate \
    tslib-tests \
    "

ARAGO_NCURSES = "\
    ncurses \
    ncurses-terminfo \
    ncurses-tools \
    "

ARAGO_FSTOOLS = "\
    e2fsprogs \
    e2fsprogs-e2fsck \
    e2fsprogs-mke2fs \
    e2fsprogs-tune2fs \
    dosfstools \
    util-linux-fdisk \
    util-linux-mkfs \
    util-linux-sfdisk \
    util-linux-fsck \
    "

ARAGO_UTILS = "\
    fbset \
    usbutils \
    i2c-tools \
    strace \
    ${@bb.utils.contains('MACHINE_FEATURES', 'pci', 'pciutils', '',d)} \
    "

# ARAGO_UTILS - ltrace fails with __cxa_demangle for now
#    ltrace 


ARAGO_SDK_PREREQ = "\
    zlib \
    libpng \
    jpeg \
    jpeg-tools \
    freetype \
    thttpd \
    "

ARAGO_CONSOLE = "\
    ${@bb.utils.contains('MACHINE_FEATURES', 'alsa', '${ARAGO_ALSA_EXTRA}', '',d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '', '${ARAGO_TSLIB}', d)} \
    ${ARAGO_NCURSES} \
    ${ARAGO_FSTOOLS} \
    ${ARAGO_UTILS} \
    ${ARAGO_SDK_PREREQ} \
    "

RDEPENDS_${PN} = "\
    ${ARAGO_CONSOLE} \
    "

RRECOMMENDS_${PN} = "\
    kernel-modules \
    "
