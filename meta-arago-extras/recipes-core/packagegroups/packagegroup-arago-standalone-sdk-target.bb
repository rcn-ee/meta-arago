DESCRIPTION = "Target packages for the standalone SDK"
PR = "r6"
LICENSE = "MIT"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

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
    ${@base_conditional('QT_PROVIDER', 'qt5', '', 'tslib-dev', d)} \
    libusb-compat-dev \
    libusb1-dev \
    zlib-dev \
    ncurses-dev \
    opkg-dev \
    sysvinit-dev \
    util-linux-dev \
    "
