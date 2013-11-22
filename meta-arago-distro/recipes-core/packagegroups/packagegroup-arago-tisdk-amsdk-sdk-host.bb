DESCRIPTION = "Task to install additional scripts and applications into the SDK"
LICENSE = "MIT"
PR = "r17"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

# Choose the kernel and u-boot recipe sources to use

U-BOOT_SRC = "${PREFERRED_PROVIDER_virtual/bootloader}-src"
KERNEL_SRC = "${PREFERRED_PROVIDER_virtual/kernel}-src"

TOOLS = "pinmux-utility"
TOOLS_omap-a15 = ""
TOOLS_ti43x = ""
TOOLS_append_am37x-evm = " flash-utility"
TOOLS_append_am3517-evm = " flash-utility"

EXTRA_FILES = ""
EXTRA_FILES_omap-a15 = "tisdk-readme tisdk-uenv"
EXTRA_FILES_ti33x = "${@base_contains('ARAGO_BRAND','amsdk','','tisdk-readme',d)}"
EXTRA_FILES_ti43x = "${@base_contains('ARAGO_BRAND','amsdk','','tisdk-readme',d)}"

RDEPENDS_${PN} = "\
    ${TOOLS} \
    ti-tisdk-setup \
    ${EXTRA_FILES} \
    oe-layersetup-src \
    ti-tisdk-makefile \
    ${U-BOOT_SRC} \
    ${KERNEL_SRC} \
    tisdk-install \
"
