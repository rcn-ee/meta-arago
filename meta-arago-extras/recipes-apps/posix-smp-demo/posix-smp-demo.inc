SUMMARY = "This recipe creates a posix-smp-demo binaries."

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://dhry.h;beginline=1;endline=377;md5=8f2fbe6e071d9ea4afeca73cfd656ec8"

POSIX_SMP_GIT_URI = "git://git.ti.com/keystone-demos/posix-smp.git"
POSIX_SMP_GIT_PROTOCOL = "git"
POSIX_SMP_GIT_BRANCH = "master"

# Below commit ID corresponds to "DEV.POSIX-SMP.01.00.01.07"
POSIX_SMP_SRCREV = "2614d4cbe9d83c8345e051c7f3767f86226398ea"

BRANCH = "${POSIX_SMP_GIT_BRANCH}"
SRC_URI = "${POSIX_SMP_GIT_URI};protocol=${POSIX_SMP_GIT_PROTOCOL};branch=${BRANCH}"

SRCREV = "${POSIX_SMP_SRCREV}"
PV = "01.00.01.07"
INC_PR = "r0"

S = "${WORKDIR}/git"
