SRC_URI_omap-a15 = "git://git.ti.com/glsdk/gstreamer0-10.git;protocol=git"
SRCREV = "e505f4a2ceee3b0328eb2efddb9ec1281d3fd60a"

# Make MACHINE specific since we pull different sources per MACHINE
PACKAGE_ARCH = "${MACHINE_ARCH}"

PR_append = "-arago1"

S_omap-a15 = "${WORKDIR}/git"

do_configure_prepend_omap-a15() {
	git submodule init && git submodule update
	autopoint -f
}
