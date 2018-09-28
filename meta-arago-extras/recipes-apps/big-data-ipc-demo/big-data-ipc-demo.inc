LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://makefile;beginline=1;endline=31;md5=2f2ea348b98d5cc7807ece7adcc2c43a"

COMPATIBLE_MACHINE = "omap-a15|keystone"
PACKAGE_ARCH = "${MACHINE_ARCH}"

BIG_DATA_IPC_GIT_URI = "git://git.ti.com/processor-sdk/big-data-ipc-examples.git"
BIG_DATA_IPC_GIT_PROTOCOL = "git"
BIG_DATA_IPC_GIT_BRANCH = "master"

# Below commit ID corresponds to "DEV.BIG_DATA_IPC.01.02.00.00"
BIG_DATA_IPC_SRCREV = "5ef821453c58e997bba0cf47aa9f54e616097861"

BRANCH = "${BIG_DATA_IPC_GIT_BRANCH}"
SRC_URI = "${BIG_DATA_IPC_GIT_URI};protocol=${BIG_DATA_IPC_GIT_PROTOCOL};branch=${BRANCH}"

SRCREV = "${BIG_DATA_IPC_SRCREV}"
PV = "01.02.00.00"

S = "${WORKDIR}/git"

PLATFORM = "UNKNOWN"
PLATFORM_omap-a15 = "DRA7XX"
PLATFORM_k2hk-evm = "TCI6636"
PLATFORM_k2l = "TCI6630"
PLATFORM_k2e = "66AK2E"
PLATFORM_k2g = "66AK2G"

IPC_TARGETS = ""
IPC_TARGETS_omap-a15 = "\
    gnu.targets.arm.A15F="${GCC_ARM_NONE_TOOLCHAIN}" \
    ti.targets.elf.C66="${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x" \
    ti.targets.arm.elf.M4="${M4_TOOLCHAIN_INSTALL_DIR}" \
"

IPC_TARGETS_keystone = " \
    gnu.targets.arm.A15F="${GCC_ARM_NONE_TOOLCHAIN}" \
    ti.targets.elf.C66="${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x" \
"
