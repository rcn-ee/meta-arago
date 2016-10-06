DESCRIPTION = "Test applications for OMAP DRM interface"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://viddec3test.c;beginline=1;endline=16;md5=c391f44e40a29096285e3121923041df"
DEPENDS += "libav libdce libdrm libgbm ti-sgx-ddk-um wayland"

inherit autotools pkgconfig

PR = "r18"
SRCREV = "e4a2932a836c54f4a20b4be9d541d11d3a246a31"

SRC_URI = "git://git.ti.com/glsdk/omapdrmtest.git;protocol=git \
"

S = "${WORKDIR}/git"

TARGET_CC_ARCH += "${LDFLAGS}"
