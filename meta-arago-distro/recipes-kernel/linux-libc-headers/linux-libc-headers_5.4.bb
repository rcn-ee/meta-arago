require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

PR_append = ".arago0"

DEPENDS += "rsync-native"

BRANCH = "ti-linux-5.4.y"
SRCREV = "c65c87b98f8d1b647c13b5bb36e5ffbad5805ff1"

KERNEL_GIT_URI = "git://git.ti.com/ti-linux-kernel/ti-linux-kernel.git"
KERNEL_GIT_PROTOCOL = "git"
SRC_URI = "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH}"

S = "${WORKDIR}/git"
