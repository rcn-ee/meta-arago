require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

PR_append = ".arago0"

BRANCH = "ti-lsk-linux-4.14.y"
SRCREV = "3e50654361c34b75784ab7c8c9aa8e96b3a37fc1"

KERNEL_GIT_URI = "git://git.ti.com/ti-linux-kernel/ti-linux-kernel.git"
KERNEL_GIT_PROTOCOL = "git"
SRC_URI = "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH}"

S = "${WORKDIR}/git"
