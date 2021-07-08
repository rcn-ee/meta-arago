require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

PR_append = ".arago0"

DEPENDS += "rsync-native"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

BRANCH = "ti-linux-5.10.y"
SRCREV = "73aa709ca10103b61fba3a07471dbb4dcb56db45"

KERNEL_GIT_URI = "git://git.ti.com/ti-linux-kernel/ti-linux-kernel.git"
KERNEL_GIT_PROTOCOL = "git"
SRC_URI = "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH}"

S = "${WORKDIR}/git"
