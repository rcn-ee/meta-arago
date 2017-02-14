require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

PR_append = ".arago1"

BRANCH = "ti-lsk-linux-4.9.y"
SRCREV = "b4aa954ead9260eaf7138755fc9d062a9f4630eb"

KERNEL_GIT_URI = "git://git.ti.com/ti-linux-kernel/ti-linux-kernel.git"
KERNEL_GIT_PROTOCOL = "git"
SRC_URI = "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH}"

S = "${WORKDIR}/git"
