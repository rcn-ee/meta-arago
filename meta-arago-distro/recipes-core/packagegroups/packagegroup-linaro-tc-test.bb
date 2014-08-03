DESCRIPTION = "Group of packages to build with Linaro toolchain for testing"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = "\
    virtual/kernel \
    u-boot \
    busybox \
    bash \
    coreutils \
    apache \
    wayland \
    weston \
    gstreamer \
    openssl \
    openssh \
    perl \
    python \
    php \
    qt4-embedded \
    qtbase \
    qtwebkit \
    "
