DESCRIPTION = "TI OpenMP-Acc host runtime and development packages"

include openmpacc.inc

PR = "${INC_PR}.1"

inherit cmake

DEPENDS = "boost boost-native opencl"
RDEPENDS_${PN} += "opencl-runtime"
RDEPENDS_${PN}-dev += "clacc"

S = "${WORKDIR}/git/host"

export TARGET_ROOTDIR = "${STAGING_DIR_HOST}"
export LINUX_DEVKIT_ROOT = "${STAGING_DIR_HOST}"

EXTRA_OECMAKE += "-DVERSION="${PV}" -DBUILD_OUTPUT=lib"

FILES_${PN} += "/usr/share/ti/openmpacc/*"

do_configure_prepend() {
	sed -i -e 's/-march=armv7-a//' ${S}/libompacc/CMakeLists.txt
}
