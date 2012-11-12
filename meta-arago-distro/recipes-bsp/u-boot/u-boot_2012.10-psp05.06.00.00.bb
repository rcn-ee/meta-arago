# Use the version of u-boot.inc in oe-core not the meta-ti version
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

# Reset OEMAKE. Current u-boot.inc sets -02 which breaks this version of u-boot's build.
# This issue was fixed in oe-core master by removing the -02 statement.
EXTRA_OEMAKE = 'CROSS_COMPILE=${TARGET_PREFIX} CC="${TARGET_PREFIX}gcc ${TOOLCHAIN_OPTIONS}"'

DESCRIPTION = "u-boot bootloader for ARM MPU devices"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

COMPATIBLE_MACHINE = "ti33x|omap3"

###################################################
# When this recipe is moved to meta-ti these changes should go in a bbappend in meta-arago-distro.

# PSPREL and UVER are used by arago-source-ipk.conf
PSPREL = "05.06.00.00"
UVER = "2012.10"
###################################################

DEFAULT_PREFERENCE = "-1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PR = "r2+gitr${SRCPV}"

SRC_URI = "git://arago-project.org/git/projects/u-boot-am33x.git;protocol=git;branch=${BRANCH} \
           file://0001-am335x_evm-fix-mmc-boot-environment-settings.patch \
"

BRANCH = "amsdk-05.06.00.00"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

UBOOT_SUFFIX = "img"

# Set the name of the SPL that will built so that it is also packaged with u-boot.
SPL_BINARY = "MLO"
