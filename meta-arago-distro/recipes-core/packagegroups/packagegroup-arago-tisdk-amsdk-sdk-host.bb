DESCRIPTION = "Task to install additional scripts and applications into the SDK"
LICENSE = "MIT"
PR = "r29"

PN = "packagegroup-arago-tisdk-amsdk-sdk-host${ARAGO_KERNEL_SUFFIX}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

# Choose the kernel and u-boot recipe sources to use
UBOOT_SRC = "${PREFERRED_PROVIDER_virtual/bootloader}-src"
KERNEL_SRC = "${PREFERRED_PROVIDER_virtual/kernel}-src"

KERNEL_SHADOW_CLONE := "${PREFERRED_PROVIDER_virtual/kernel}"
KERNEL_SHADOW_CLONE_ENABLED := "${SRCIPK_SHALLOW_CLONE_pn-${KERNEL_SHADOW_CLONE}}"

BOOT_MONITOR = ""
BOOT_MONITOR_keystone = "boot-monitor-src"

EXTRA_FILES = ""
EXTRA_FILES_ti43x = "tisdk-uenv"
EXTRA_FILES_omap-a15 = "tisdk-readme tisdk-uenv"
EXTRA_FILES_k3 = "tisdk-readme tisdk-uenv ti-sci-fw-src"

RDEPENDS_${PN} = "\
    ti-tisdk-setup \
    ${EXTRA_FILES} \
    ti-tisdk-makefile \
    ${UBOOT_SRC} \
    ${KERNEL_SRC} \
    ${BOOT_MONITOR} \
    ${@base_conditional('KERNEL_SHADOW_CLONE_ENABLED','true','unshallow-repositories','',d)} \
    tisdk-install \
"
