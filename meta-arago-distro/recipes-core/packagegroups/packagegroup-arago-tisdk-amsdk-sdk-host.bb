DESCRIPTION = "Task to install additional scripts and applications into the SDK"
LICENSE = "MIT"
PR = "r29"

PN = "packagegroup-arago-tisdk-amsdk-sdk-host${ARAGO_KERNEL_SUFFIX}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

# Choose the kernel and u-boot recipe sources to use
UBOOT_SRC = "${PREFERRED_PROVIDER_virtual/bootloader}-source"
KERNEL_SRC = "${PREFERRED_PROVIDER_virtual/kernel}-source"

KERNEL_SHADOW_CLONE := "${PREFERRED_PROVIDER_virtual/kernel}"
KERNEL_SHADOW_CLONE_ENABLED := "${SRCIPK_SHALLOW_CLONE:pn-${KERNEL_SHADOW_CLONE}}"

EXTRA_FILES = ""
EXTRA_FILES:ti43x = "tisdk-uenv"
EXTRA_FILES:omap-a15 = "tisdk-readme tisdk-uenv"
EXTRA_FILES:k3 = "tisdk-readme tisdk-uenv"

RDEPENDS:${PN} = "\
    ti-tisdk-setup \
    ${EXTRA_FILES} \
    ti-tisdk-makefile \
    ${UBOOT_SRC} \
    ${KERNEL_SRC} \
    ${@oe.utils.conditional('KERNEL_SHADOW_CLONE_ENABLED','true','unshallow-repositories','',d)} \
    tisdk-install \
"
