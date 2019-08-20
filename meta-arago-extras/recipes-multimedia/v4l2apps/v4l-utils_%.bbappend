FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PV = "1.16.99+1.17-rc+git${SRCPV}"

SRCREV = "9343eaf5433135b3360e34db606c0d7de95ed289"

SRC_URI = " \
	git://linuxtv.org/v4l-utils.git \
	file://0001-Revert-media-ctl-Don-t-install-libmediactl-and-libv4.patch \
	file://mediactl-pkgconfig.patch \
	file://export-mediactl-headers.patch \
	file://0002-contrib-test-Link-mc_nextgen_test-with-libargp-if-ne.patch \
	file://0003-v4l2-ctl-Do-not-use-getsubopt.patch \
	file://0001-Makefile.am-skip-po-dirs-for-now.patch \
"

S = "${WORKDIR}/git"
B = "${S}"

do_configure() {
	./bootstrap.sh
	oe_runconf
}
