SUMMARY = "Test applications for OMAP DRM interface"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://viddec3test.c;beginline=1;endline=16;md5=c391f44e40a29096285e3121923041df"

DEPENDS = "ffmpeg libdce libdrm libgbm ti-sgx-ddk-um wayland"

inherit autotools pkgconfig

PR = "r27"
SRCREV = "b6c02d24be6f8dae939168c154cf2345b33e459d"

EXTRA_OEMAKE = "CC="${CC}""
TARGET_CC_ARCH += "${LDFLAGS}"

SRC_URI = "git://git.ti.com/glsdk/omapdrmtest.git;protocol=git \
"

S = "${WORKDIR}/git"
