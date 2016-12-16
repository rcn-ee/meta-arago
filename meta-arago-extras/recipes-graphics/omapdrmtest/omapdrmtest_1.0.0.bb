SUMMARY = "Test applications for OMAP DRM interface"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://viddec3test.c;beginline=1;endline=16;md5=c391f44e40a29096285e3121923041df"

DEPENDS = "ffmpeg libdce libdrm libgbm ti-sgx-ddk-um wayland"

inherit autotools pkgconfig

PR = "r19"
SRCREV = "47bbb6b2ec48bbee35f9dc7192c05e48fd1a2589"

EXTRA_OEMAKE = "CC="${CC}""
TARGET_CC_ARCH += "${LDFLAGS}"

SRC_URI = "git://git.ti.com/glsdk/omapdrmtest.git;protocol=git \
           file://0001-configure.ac-also-check-for-libavcodec-library.patch"

S = "${WORKDIR}/git"
