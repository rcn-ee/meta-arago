DESCRIPTION = "Task to install additional scripts and applications into the SDK"
LICENSE = "MIT"
PR = "r3"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

# Choose the kernel and u-boot recipe sources to use
U-BOOT_SRC = ""
KERNEL_SRC = ""

U-BOOT_SRC_am335x-evm = "u-boot-src"
KERNEL_SRC_am335x-evm = "linux-am335x-src"

TOOLS = "pinmux-utility"
TOOLS_am37x-evm_append = " flash-utility"
TOOLS_am3517-evm_append = " flash-utility"

RDEPENDS_${PN} = "\
    ${TOOLS} \
    ti-tisdk-setup \
    board-port-labs-src \
    ti-tisdk-makefile \
    ${U-BOOT_SRC} \
    ${KERNEL_SRC} \
"
