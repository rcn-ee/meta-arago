DESCRIPTION = "Task to install additional scripts and applications into the SDK"
LICENSE = "MIT"
PR = "r8"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

# Choose the kernel and u-boot recipe sources to use

U-BOOT_SRC = "${PREFERRED_PROVIDER_virtual/bootloader}-src"
KERNEL_SRC = "${PREFERRED_PROVIDER_virtual/kernel}-src"

TOOLS = "pinmux-utility"
TOOLS_omap-a15 = ""
TOOLS_append_am37x-evm = " flash-utility"
TOOLS_append_am3517-evm = " flash-utility"

README = ""
README_omap-a15 = "tisdk-readme"
README_ti33x = "tisdk-readme"

RDEPENDS_${PN} = "\
    ${TOOLS} \
    ti-tisdk-setup \
    tisdk-uenv \
    ${README} \
    board-port-labs-src \
    ti-tisdk-makefile \
    ${U-BOOT_SRC} \
    ${KERNEL_SRC} \
"
