LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://makefile;beginline=1;endline=31;md5=2f2ea348b98d5cc7807ece7adcc2c43a"

COMPATIBLE_MACHINE = "omap-a15"
PACKAGE_ARCH = "${MACHINE_ARCH}"

BIG_DATA_IPC_GIT_URI = "git://git.ti.com/processor-sdk/big-data-ipc-examples.git"
BIG_DATA_IPC_GIT_PROTOCOL = "git"
BIG_DATA_IPC_GIT_BRANCH = "master"

# Below commit ID corresponds to "DEV.BIG_DATA_IPC.01.03.00.00"
BIG_DATA_IPC_SRCREV = "984edb3c69c8a1f51da02e0abcd2201319650894"

BRANCH = "${BIG_DATA_IPC_GIT_BRANCH}"
SRC_URI = "${BIG_DATA_IPC_GIT_URI};protocol=${BIG_DATA_IPC_GIT_PROTOCOL};branch=${BRANCH}"

SRCREV = "${BIG_DATA_IPC_SRCREV}"
PV = "01.03.00.00"

S = "${WORKDIR}/git"

PLATFORM = "UNKNOWN"
PLATFORM:omap-a15 = "DRA7XX"

IPC_TARGETS = ""
IPC_TARGETS:omap-a15 = "\
    gnu.targets.arm.A15F="${GCC_ARM_NONE_TOOLCHAIN}" \
    ti.targets.elf.C66="${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x" \
    ti.targets.arm.elf.M4="${M4_TOOLCHAIN_INSTALL_DIR}" \
"
