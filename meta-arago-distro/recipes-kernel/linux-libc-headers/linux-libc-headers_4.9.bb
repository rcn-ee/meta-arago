require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

PR_append = ".arago0"

BRANCH = "ti-lsk-linux-4.9.y"
SRCREV = "20e747cb77b81fce68c4b7ee3cfa24e10aedf484"

KERNEL_GIT_URI = "git://git.ti.com/ti-linux-kernel/ti-linux-kernel.git"
KERNEL_GIT_PROTOCOL = "git"
SRC_URI = "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH}"

S = "${WORKDIR}/git"
