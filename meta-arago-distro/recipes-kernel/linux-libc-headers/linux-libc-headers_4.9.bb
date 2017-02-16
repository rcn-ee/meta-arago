require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

PR_append = ".arago2"

BRANCH = "ti-lsk-linux-4.9.y"
SRCREV = "1c74e8801cf58a30394ae92236895599f2c77253"

KERNEL_GIT_URI = "git://git.ti.com/ti-linux-kernel/ti-linux-kernel.git"
KERNEL_GIT_PROTOCOL = "git"
SRC_URI = "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH}"

S = "${WORKDIR}/git"
