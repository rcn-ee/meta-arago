DESCRIPTION = "Group of packages to build with Linaro toolchain for testing"
LICENSE = "MIT"

PR = "r1"

inherit packagegroup

RDEPENDS_${PN} = "\
    virtual/kernel \
    u-boot \
    busybox \
    bash \
    coreutils \
    apache \
    ${@base_contains('DISTRO_FEATURES', 'wayland', 'wayland weston', '', d)} \
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
