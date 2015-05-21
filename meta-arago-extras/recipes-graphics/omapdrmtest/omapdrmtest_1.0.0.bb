DESCRIPTION = "Test applications for OMAP DRM interface"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://viddec3test.c;beginline=1;endline=16;md5=c391f44e40a29096285e3121923041df"
DEPENDS += "libav libdce libdrm libgbm omap5-sgx-ddk-um-linux wayland"

inherit autotools pkgconfig

PR = "r6"
SRCREV = "a2f483ef833ce7a6f3e0b975d9e49267960b288e"

SRC_URI = "git://git.ti.com/glsdk/omapdrmtest.git;protocol=git"

S = "${WORKDIR}/git"

INSANE_SKIP_omapdrmtest = "dev-deps"
