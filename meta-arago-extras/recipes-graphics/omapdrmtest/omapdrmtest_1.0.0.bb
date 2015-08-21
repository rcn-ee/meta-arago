DESCRIPTION = "Test applications for OMAP DRM interface"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://viddec3test.c;beginline=1;endline=16;md5=c391f44e40a29096285e3121923041df"
DEPENDS += "libav libdce libdrm libgbm omap5-sgx-ddk-um-linux wayland"

inherit autotools pkgconfig

PR = "r8"
SRCREV = "24db635c4689291ae350d0c940b30ba7203dc5b7"

SRC_URI = "git://git.ti.com/glsdk/omapdrmtest.git;protocol=git \
	file://0001-util-demux-update-use-of-deprecated-API.patch \
"

S = "${WORKDIR}/git"

TARGET_CC_ARCH += "${LDFLAGS}"
