PR_append = ".arago0"

BRANCH = "ti-lsk-linux-4.4.y"
SRCREV = "6580f85400b48d55d06f11d6b75c056399123a72"

KERNEL_GIT_URI = "git://git.ti.com/ti-linux-kernel/ti-linux-kernel.git"
KERNEL_GIT_PROTOCOL = "git"
SRC_URI = "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH}"

S = "${WORKDIR}/git"
