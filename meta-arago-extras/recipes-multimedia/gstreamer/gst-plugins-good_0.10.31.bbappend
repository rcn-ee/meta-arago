PR_append = "-arago1"

# Make MACHINE specific since we pull different sources per MACHINE
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI_omap-a15 = "git://git.ti.com/glsdk/gst-plugins-good0-10.git;protocol=git"
SRCREV = "733289614c50ff4e490d5a37ec4af3a540d1dfb9"

# Fix compile errors with recent kernels
SRC_URI_append_omap-a15 = " file://0001-v4l2-fix-build-with-recent-kernels-the-v4l2_buffer-i.patch \
            file://0001-v4l2_calls-define-V4L2_CID_HCENTER-and-V4L2_CID_VCEN.patch"

S_omap-a15 = "${WORKDIR}/git"

do_configure_prepend_omap-a15() {
	git submodule init && git submodule update
	autopoint -f
}

FILES_${PN} += "\
                ${libdir}/*.so \
                ${libdir}/gstreamer-0.10/*"

