PR_append = ".arago1"

BRANCH = "ti-lsk-linux-4.4.y"
SRCREV = "2612ef5805db717f9818f06786e863d3b1a7f87e"

KERNEL_GIT_URI = "git://git.ti.com/ti-linux-kernel/ti-linux-kernel.git"
KERNEL_GIT_PROTOCOL = "git"
SRC_URI = "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH}"

S = "${WORKDIR}/git"
