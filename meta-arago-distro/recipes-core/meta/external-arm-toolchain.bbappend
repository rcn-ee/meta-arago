# This is a rather hacky way to install custom linux-libc-headers
# on top of the external-arm-toolchain, since simply depending
# on linux-libc-headers creates circular dependencies now. Mostly
# duplication of code from corresponding recipe.

BRANCH = "ti-linux-4.19.y"
SRCREV = "8de817772462078a064b70d368eeae3b92a31439"

KERNEL_GIT_URI = "git://git.ti.com/ti-linux-kernel/ti-linux-kernel.git"
KERNEL_GIT_PROTOCOL = "git"
SRC_URI += "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH}"

PKGV_linux-libc-headers-dev = "4.19"
PKGV_linux-libc-headers = "4.19"

inherit kernel-arch pkgconfig multilib_header

EXTRA_OEMAKE = " HOSTCC="${BUILD_CC}" HOSTCPP="${BUILD_CPP}""

DEPENDS += "bison-native"

do_configure_append() {
	cd ${WORKDIR}/git
	oe_runmake allnoconfig
}

do_install_append() {
	cd ${WORKDIR}/git
	oe_runmake headers_install INSTALL_HDR_PATH=${B}${exec_prefix}

	CP_ARGS="-Prf --preserve=mode,timestamps --no-preserve=ownership"
	cp ${CP_ARGS} ${B}${includedir} ${D}${exec_prefix}

	# The ..install.cmd conflicts between various configure runs
	find ${D}${exec_prefix} -name ..install.cmd | xargs rm -f
}
