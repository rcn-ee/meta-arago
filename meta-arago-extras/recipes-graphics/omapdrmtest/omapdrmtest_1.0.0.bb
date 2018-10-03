SUMMARY = "Test applications for OMAP DRM interface"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://viddec3test.c;beginline=1;endline=16;md5=c391f44e40a29096285e3121923041df"

DEPENDS = "ffmpeg libdce libdrm libgbm ti-sgx-ddk-um wayland"

inherit autotools pkgconfig

PR = "r28"
SRCREV = "20338b9f575ffe9c18c12bbed41c16069d27ccf4"

EXTRA_OEMAKE = "CC="${CC}""
TARGET_CC_ARCH += "${LDFLAGS}"

SRC_URI = "git://git.ti.com/glsdk/omapdrmtest.git;protocol=git \
        file://0001-Makefile.am-lblah-flags-belong-to-LDADD-not-LDFLAGS.patch \
"

S = "${WORKDIR}/git"
