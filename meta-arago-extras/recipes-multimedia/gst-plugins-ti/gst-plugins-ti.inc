# Include file for common build settings for TI GStreamer plugins
DEPENDS += "gstreamer gst-plugins-base gst-plugins-bad libdrm libdce"

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

FILES_${PN} += "${libdir}/gstreamer-0.10/*"
