require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

# upstream moved to 4.18 with updated SPDX license files, use old checksum
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

PR_append = ".arago0"

BRANCH = "ti-lsk-linux-4.14.y"
SRCREV = "3bacc614e300e497679bdd7d2759f486e713f373"

KERNEL_GIT_URI = "git://git.ti.com/ti-linux-kernel/ti-linux-kernel.git"
KERNEL_GIT_PROTOCOL = "git"
SRC_URI = "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH}"

S = "${WORKDIR}/git"

# upstream added few more headers that aren't in 4.14, reduce the list for 4.14
do_install_armmultilib () {
    oe_multilib_header asm/auxvec.h asm/bitsperlong.h asm/byteorder.h asm/fcntl.h asm/hwcap.h asm/ioctls.h asm/kvm.h asm/mman.h asm/param.h asm/perf_regs.h
    oe_multilib_header asm/posix_types.h asm/ptrace.h asm/setup.h asm/sigcontext.h asm/siginfo.h asm/signal.h asm/stat.h asm/statfs.h asm/swab.h asm/types.h asm/unistd.h
}
