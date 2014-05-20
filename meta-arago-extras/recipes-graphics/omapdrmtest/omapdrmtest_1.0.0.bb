DESCRIPTION = "Test applications for OMAP DRM interface"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://viddec3test.c;beginline=1;endline=16;md5=c391f44e40a29096285e3121923041df"
DEPENDS += "libdrm libdce libav"

inherit autotools pkgconfig

PR = "r3"
SRCREV = "64e4e389dd8be4947c107a057f34556a4280281a"

SRC_URI = "git://git.ti.com/glsdk/omapdrmtest.git;protocol=git"

S = "${WORKDIR}/git"

INSANE_SKIP_omapdrmtest = "dev-deps"
