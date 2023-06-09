SUMMARY = "TI Big data IPC: Host linux examples"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://makefile;beginline=1;endline=31;md5=2f2ea348b98d5cc7807ece7adcc2c43a"

SRC_URI = "git://git.ti.com/processor-sdk/big-data-ipc-examples.git;protocol=git;branch=master"
SRCREV = "3dedbde2a539834ee8f4d0419888116ea80789d0"
PV = "01.03.00.01"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "omap-a15"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit features_check

REQUIRED_MACHINE_FEATURES = "dsp"

DEPENDS = "ti-ipc \
           ti-xdctools-native \
           ti-sysbios \
           ti-ipc-rtos \
           ti-cgt6x-native \
           virtual/kernel \
"

do_configure[depends] += "virtual/kernel:do_shared_workdir"

PLATFORM = "UNKNOWN"
PLATFORM:omap-a15 = "DRA7XX"

require recipes-ti/includes/ti-paths.inc

EXTRA_OEMAKE = "\
    PLATFORM=${PLATFORM} \
    XDC_INSTALL_DIR="${XDC_INSTALL_DIR}" \
    BIOS_INSTALL_DIR="${SYSBIOS_INSTALL_DIR}" \
    IPC_INSTALL_DIR="${IPC_INSTALL_DIR}" \
    LINUX_SYSROOT_DIR="${STAGING_KERNEL_DIR}/include/uapi -I${STAGING_KERNEL_DIR}/include" \
    gnu.targets.arm.A15F="${GCC_ARM_NONE_TOOLCHAIN}" \
    ti.targets.elf.C66="${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x" \
"

do_compile() {
    oe_runmake host_linux
}

do_install() {
    oe_runmake EXEC_DIR="${D}${bindir}" install_linux_bin
}

PACKAGES =+ "${PN}-firmware"
FILES:${PN}-firmware += "${bindir}/simple_buffer_example/release/server_dsp.xe66"
INSANE_SKIP:${PN}-firmware += "arch"
