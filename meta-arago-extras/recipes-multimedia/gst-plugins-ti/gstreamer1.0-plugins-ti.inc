# Include file for common build settings for TI GStreamer plugins
DEPENDS += "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad libdrm libdce"

inherit autotools pkgconfig gettext

INC_PR = "r0"

S = "${WORKDIR}/git"

do_configure() {
	cd ${S}
	chmod +x autogen.sh
	./autogen.sh --host=arm-linux --with-libtool-sysroot=${STAGING_DIR_TARGET} --prefix=/usr
}

EXTRA_OECONF += "--enable-maintainer-mode"
EXTRA_OEMAKE += "'ERROR_CFLAGS=-Wno-deprecated-declarations'"

FILES_${PN} += "${libdir}/gstreamer-1.0/*.so"
