require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

PR_append = ".arago0"

BRANCH = "ti-lsk-linux-4.14.y"
SRCREV = "3bacc614e300e497679bdd7d2759f486e713f373"

KERNEL_GIT_URI = "git://git.ti.com/ti-linux-kernel/ti-linux-kernel.git"
KERNEL_GIT_PROTOCOL = "git"
SRC_URI = "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH}"

S = "${WORKDIR}/git"
