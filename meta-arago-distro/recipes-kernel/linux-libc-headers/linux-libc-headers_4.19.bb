require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

PR_append = ".arago1"

BRANCH = "ti-linux-4.19.y"
SRCREV = "50ceb3c6e7f2d5f54d66d4999e79d3c4e09796df"

KERNEL_GIT_URI = "git://git.ti.com/ti-linux-kernel/ti-linux-kernel.git"
KERNEL_GIT_PROTOCOL = "git"
SRC_URI = "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH}"

S = "${WORKDIR}/git"
