PR_append = "-arago1"

# Make MACHINE specific since we pull different sources per MACHINE
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI_omap-a15 = "git://git.ti.com/glsdk/gst-plugins-base0-10.git;protocol=git"
SRCREV = "21305017f6095ad6e9b1a8f1006ee5be780b21f8"

S_omap-a15 = "${WORKDIR}/git"

do_configure_prepend_omap-a15() {
	git submodule init && git submodule update
	autopoint -f
}

EXTRA_OECONF +="--disable-ivorbis "

FILES_${PN} += "\
                ${libdir}/*.so \
                ${libdir}/gstreamer-0.10/*"
