DESCRIPTION = "Test applications for OMAP DRM interface"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://viddec3test.c;beginline=1;endline=16;md5=c391f44e40a29096285e3121923041df"
DEPENDS += "libav libdce libdrm libgbm omap5-sgx-ddk-um-linux"

inherit autotools pkgconfig

PR = "r4"
SRCREV = "04da689692ec7cd3ef0f315c9c00d9051cefdd10"

SRC_URI = "git://git.ti.com/glsdk/omapdrmtest.git;protocol=git"

S = "${WORKDIR}/git"

INSANE_SKIP_omapdrmtest = "dev-deps"
