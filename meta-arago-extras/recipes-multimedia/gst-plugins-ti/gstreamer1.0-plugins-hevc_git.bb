DESCRIPTION = "GStreamer plugin for ARM HEVC decoder"
HOMEPAGE = "https://git.ti.com/processor-sdk/gst-plugin-hevc"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=2827f94fc0a1adeff4d9702e97ce2979"

COMPATIBLE_MACHINE = "dra7xx|keystone"

SRC_URI = "git://git.ti.com/processor-sdk/gst-plugin-hevc.git;protocol=git"
SRCREV = "e4ea007d0ddeb95ae01742293454ef3c87a6e84c"

S = "${WORKDIR}/git"

DEPENDS += "gstreamer1.0 gstreamer1.0-plugins-base hevc-arm-decoder"

inherit autotools-brokensep pkgconfig gettext

PR = "r5"

do_configure() {
        cd ${S}
        chmod +x autogen.sh
        ./autogen.sh --host=arm-linux --with-libtool-sysroot=${STAGING_DIR_TARGET} --prefix=/usr
}

EXTRA_OECONF += "--enable-maintainer-mode"
EXTRA_OEMAKE += "'ERROR_CFLAGS=-Wno-deprecated-declarations'"

FILES_${PN} += "${libdir}/gstreamer-1.0/*.so"
FILES_${PN}-dbg += "${libdir}/gstreamer-1.0/.debug"
FILES_${PN}-dev += "${libdir}/gstreamer-1.0/*.la"
