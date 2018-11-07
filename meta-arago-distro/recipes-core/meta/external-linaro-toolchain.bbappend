# This is a rather hacky way to install custom linux-libc-headers
# on top of the external-linaro-toolchain, since simply depending
# on linux-libc-headers creates circular dependencies now. Mostly
# duplication of code from corresponding recipe.

BRANCH = "ti-lsk-linux-4.14.y"
SRCREV = "3e50654361c34b75784ab7c8c9aa8e96b3a37fc1"

KERNEL_GIT_URI = "git://git.ti.com/ti-linux-kernel/ti-linux-kernel.git"
KERNEL_GIT_PROTOCOL = "git"
SRC_URI += "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH}"

PKGV_linux-libc-headers-dev = "4.14"
PKGV_linux-libc-headers = "4.14"

inherit kernel-arch pkgconfig multilib_header

EXTRA_OEMAKE = " HOSTCC="${BUILD_CC}" HOSTCPP="${BUILD_CPP}""

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

do_install_append_aarch64 () {
        do_install_asm_armmultilib
}

do_install_append_arm () {
	do_install_asm_armmultilib
}

do_install_asm_armmultilib () {
	oe_multilib_header asm/auxvec.h asm/bitsperlong.h asm/byteorder.h asm/fcntl.h asm/hwcap.h asm/ioctls.h asm/kvm.h asm/mman.h asm/param.h asm/perf_regs.h
	oe_multilib_header asm/posix_types.h asm/ptrace.h  asm/setup.h  asm/sigcontext.h asm/siginfo.h asm/signal.h asm/stat.h  asm/statfs.h asm/swab.h  asm/types.h asm/unistd.h
}
