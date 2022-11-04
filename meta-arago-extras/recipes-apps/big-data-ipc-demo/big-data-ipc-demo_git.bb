SUMMARY = "TI Big data IPC: Host linux examples"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://makefile;beginline=1;endline=31;md5=2f2ea348b98d5cc7807ece7adcc2c43a"

SRC_URI = "git://git.ti.com/processor-sdk/big-data-ipc-examples.git;protocol=git;branch=master"
SRCREV = "984edb3c69c8a1f51da02e0abcd2201319650894"
PV = "01.03.00.00"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "omap-a15"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit features_check

REQUIRED_MACHINE_FEATURES = "dsp"

DEPENDS = "ti-ipc \
           ti-xdctools-native \
           ti-sysbios \
           ti-ipc-rtos \
           cmem \
           ti-cgt6x-native \
"

PLATFORM = "UNKNOWN"
PLATFORM:omap-a15 = "DRA7XX"

require recipes-ti/includes/ti-paths.inc

EXTRA_OEMAKE = "\
    PLATFORM=${PLATFORM} \
    XDC_INSTALL_DIR="${XDC_INSTALL_DIR}" \
    BIOS_INSTALL_DIR="${SYSBIOS_INSTALL_DIR}" \
    IPC_INSTALL_DIR="${IPC_INSTALL_DIR}" \
    LINUX_SYSROOT_DIR="${STAGING_INCDIR}" \
    gnu.targets.arm.A15F="${GCC_ARM_NONE_TOOLCHAIN}" \
    ti.targets.elf.C66="${STAGING_DIR_NATIVE}/usr/share/ti/cgt-c6x" \
    ti.targets.arm.elf.M4="${M4_TOOLCHAIN_INSTALL_DIR}" \
"

do_create_srcipk:prepend() {
    rm -rf host_bios
}

do_compile() {
    oe_runmake host_linux
}

do_install() {
    oe_runmake EXEC_DIR="${D}${bindir}" install_linux_bin
}

PACKAGES =+ "${PN}-firmware"
FILES:${PN}-firmware += "${bindir}/simple_buffer_example/release/server_dsp.xe66"
INSANE_SKIP:${PN}-firmware += "arch"
