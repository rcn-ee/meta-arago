DESCRIPTION = "Target packages for the standalone SDK"
PR = "r2"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
ALLOW_EMPTY = "1"

PACKAGES = "${PN} ${PN}-dbg"

RDEPENDS_${PN} = "\
    libgcc \
    libgcc-dev \
    libstdc++ \
    libstdc++-dev \
    ${LIBC_DEPENDENCIES} \
    linux-libc-headers-dev \
    gdbserver \
    alsa-dev \
    alsa-lib-dev \
    alsa-utils-dev \
    curl-dev \
    i2c-tools-dev \
    freetype-dev \
    ${@base_conditional('PREFERRED_PROVIDER_jpeg', 'libjpeg-turbo', 'libjpeg-turbo-dev', 'jpeg-dev', d)}  \
    lzo-dev \
    libopkg-dev \
    libpng-dev \
    readline-dev \
    tslib-dev \
    libusb-compat-dev \
    libusb1-dev \
    zlib-dev \
    ncurses-dev \
    opkg-dev \
    sysvinit-dev \
    util-linux-dev \
    "
