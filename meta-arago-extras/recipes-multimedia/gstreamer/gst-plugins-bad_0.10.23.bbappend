DEPENDS_append_omap-a15 = " omap5-sgx-ddk-um-linux libdce libdrm wayland "

# Make MACHINE specific since we pull different sources per MACHINE
PACKAGE_ARCH = "${MACHINE_ARCH}"

PR_append = "-arago1"

SRCREV = "f2df6f3b684f39500e22115b160191cef6d7dbaf"
SRC_URI_omap-a15 = "git://git.ti.com/glsdk/gst-plugins-bad0-10.git;protocol=git"

S_omap-a15 = "${WORKDIR}/git"

EXTRA_OECONF += " --disable-pvr"

do_configure_prepend_omap-a15() {
	git submodule init && git submodule update
	autopoint -f
}

FILES_${PN} += "\
                ${libdir}/*.so \
                ${libdir}/gstreamer-0.10/*"
