DESCRIPTION = "Test applications for OMAP DRM interface"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://viddec3test.c;beginline=1;endline=16;md5=c391f44e40a29096285e3121923041df"
DEPENDS += "libav libdce libdrm libgbm omap5-sgx-ddk-um-linux wayland"

inherit autotools pkgconfig

PR = "r9"
SRCREV = "152713c45d7972ed08f506255c43ce7ff634a9f5"

SRC_URI = "git://git.ti.com/glsdk/omapdrmtest.git;protocol=git"

S = "${WORKDIR}/git"

TARGET_CC_ARCH += "${LDFLAGS}"
