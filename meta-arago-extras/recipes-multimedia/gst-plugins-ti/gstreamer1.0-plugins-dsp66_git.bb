DESCRIPTION = "GStreamer elements to use the TI DSP C66 in multimedia applications"
HOMEPAGE = "https://git.ti.com/processor-sdk/gst-plugin-dsp66"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=2827f94fc0a1adeff4d9702e97ce2979"

SRC_URI = "git://git.ti.com/processor-sdk/gst-plugin-dsp66.git;protocol=git;branch=master \
	file://0001-Makefile-correct-use-of-CPP-CXX-and-other-standard-v.patch \
	file://0001-configure.ac-stop-using-export-symbols-regex.patch \
"
SRCREV = "0abedafadbed693592804f23482a9447d81b2dbf"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "dra7xx|keystone"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base opencl ti-cgt6x-native clocl-native imglib-c66x vlib-c66x gettext-native"

inherit autotools-brokensep pkgconfig gettext

PR = "r1"

RDEPENDS_${PN} += "opencl-runtime"

EXTRA_OEMAKE = " TARGET_ROOTDIR=${STAGING_DIR_HOST} \
                 TI_OCL_CGT_INSTALL=${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x \
"

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

FILES_${PN} += "${libdir}/*.so"
FILES_${PN}-dbg += "${libdir}/.debug"
FILES_${PN}-dev += "${libdir}/*.la"
FILES_SOLIBSDEV = ""

INSANE_SKIP_${PN} = "ldflags"
