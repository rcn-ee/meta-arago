require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

PR_append = ".arago0"

BRANCH = "ti-linux-4.19.y"
SRCREV = "8de817772462078a064b70d368eeae3b92a31439"

KERNEL_GIT_URI = "git://git.ti.com/ti-linux-kernel/ti-linux-kernel.git"
KERNEL_GIT_PROTOCOL = "git"
SRC_URI = "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH}"

S = "${WORKDIR}/git"
